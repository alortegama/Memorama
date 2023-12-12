package ad.cfp.memory.test
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
        assertEquals(game.pendingCards, 7)
    }

    @Test
    fun `Jugar dues cartes diferents`() {
        val buttons = getButtons()
        val button1 = buttons[0]
        val button2 = buttons[1]
        game.cards[0] = 1
        game.cards[1] = 2
        game.play(button1, 0)
        game.play(button2, 1)
        assertEquals(game.rotateCard, 0)
        assertEquals(game.lastButton, null)
        assertEquals(game.pendingCards, 8)
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
        buttons.forEach {
            game.play(it, buttons.indexOf(it))
        }

        assertEquals(game.rotateCard, 0)
        assertEquals(game.lastButton, null)
        assertEquals(game.pendingCards, 0)

    }
}