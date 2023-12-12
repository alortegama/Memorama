package ad.cfp.memory

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class Exercici7Test : GuiTest() {


    @BeforeEach
    fun play() {

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
    }

    @Test
    fun `Comprovar que s'han resblert les tarjetesPendents per girar`() {
        assertEquals(0, game.pendingCards)
        game.resetBoard()
        assertEquals(8, game.pendingCards)
    }

    @Test
    fun `Comprovar que s'ha eliminat el text de cada botó`() {

        getButtons().forEach {
            assertNotEquals(null, it.text)
        }
        game.resetBoard()
        getButtons().forEach {
            assertEquals("", it.text)
        }
    }

    @Test
    fun `Comprovar que no hi ha cap tarjeta rotada`() {
        game.resetBoard()
        assertEquals(0, game.rotateCard)
    }

    @Test
    fun `Comprovar que no hi ha cap botó emmagatzemat a lastButton`() {
        game.resetBoard()
        assertNull(game.lastButton)
    }

    @Test
    fun `Comprovar que els números de les tarjetes s'han tornat a generar `() {
        val previous = game.cards.copyOf()
        game.resetBoard()
        assertNotEquals(previous, game.cards)
    }

}