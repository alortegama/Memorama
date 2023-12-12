package ad.cfp.memory

import ad.cfp.memory.GuiTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class Exercici3Test : GuiTest() {

    @Test
    fun `Afegir a la posició 5 al tauler buit`() {
        game.addNumberInArray(5)
        assertTrue(
            game.cards[5] != 0,
            "Al cridar a la funció addNumberInArray(5), la posició [5] ha de tenir un valor diferent de 0"
        )
    }

    @Test
    fun `Intentar afegir un nombre a una posició fora del array`() {
        val exception = assertThrows<IndexOutOfBoundsException> {
            game.addNumberInArray(25)
        }
        assertEquals("Index 25 fora del rang de 16 posicions", exception.message)
    }

    @Test
    fun `Afegir a la posició 7 al tauler buit`() { // Change test name to reflect new boundary index
        game.addNumberInArray(7)
        assertTrue(game.cards[7] != 0,
            "Al cridar a la funció addNumberInArray(7), la posició [7] ha de tenir un valor diferent de 0")
    }

    @Test
    fun `Emplenar tot el taulell`() {
        for (i in 0 until 16) {
            game.addNumberInArray(i)
        }
        val counts = mutableMapOf(
            1 to 0,
            2 to 0,
            3 to 0,
            4 to 0,
            5 to 0,
            6 to 0,
            7 to 0,
            8 to 0,
        )

        for (i in game.cards) {
            counts[i] = counts.get(i)!! + 1
        }

        for (i in 1..8) { // Check if each number appears exactly twice
            assertEquals(2, counts[i], "El valor $i apareix ${counts[i]} vegades")
        }
    }
}