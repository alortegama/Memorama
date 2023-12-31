package ad.cfp.memory

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Exercici6Test : GuiTest() {
    @Test
    fun `Jugar dos vegades la mateixa carta no té cap efecte en el joc`() {
        val buttons = getButtons()
        val button1 = buttons[0]
        val button2 = buttons[1]

        game.play(button1, 0)

        assertEquals(game.rotateCard, game.cards[0])
        assertEquals(game.lastButton, button1)
        assertEquals(game.pendingCards, 8)
        game.play(button1, 1)
        assertEquals(game.rotateCard, game.cards[0])
        assertEquals(game.lastButton, button1)
        assertEquals(game.pendingCards, 8)

    }

    @Test
    fun `Jugar dues cartes iguals`() {
        val buttons = getButtons()
        val button1 = buttons[0]
        val button2 = buttons[1]
        game.cards[0] = 1
        game.cards[1] = 1

        game.play(button1, 0)
        game.play(button2, 1)
        assertEquals(game.rotateCard, 0)
        assertEquals(game.lastButton, null)
        assertEquals(7, game.pendingCards)
    }

    @Test
    fun `Jugar dues cartes diferents`() {
        val buttons = getButtons()
        val button1 = buttons[0]
        val button2 = buttons[1]
        game.cards[0] = 1
        game.cards[1] = 2
        game.writeNumberInButton(button1, 0)
        game.writeNumberInButton(button2, 1)
        game.play(button1, 0)
        game.play(button2, 1)
        assertEquals(game.rotateCard, 0)
        assertEquals(game.lastButton, null)
        assertEquals(8, game.pendingCards)
    }

    @Test
    fun `Completar el tauler`() {
        val buttons = getButtons()

        val totalCards = 16
        // the game card value occurs in pairs
        for (i in 0 until totalCards / 2) {
            game.cards[2 * i] = i + 1
            game.cards[2 * i + 1] = i + 1
        }
        buttons.forEachIndexed { index, it ->
            game.writeNumberInButton(it, index)
            game.play(it, index)
        }

        assertEquals(game.rotateCard, 0)
        assertEquals(game.lastButton, null)
        assertEquals(0, game.pendingCards)

    }
}