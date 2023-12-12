package ad.cfp.memory

import ad.cfp.memory.GuiTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Exercici2Test : GuiTest() {

    @Test
    fun `Hi ha un nombre igual en tot l'array tarjetes`() {
        game.cards[0] = 1
        game.cards[1] = 1
        game.cards[2] = 5
        game.cards[3] = 7
        game.cards[4] = 1
        game.cards[5] = 2
        game.cards[6] = 6
        game.cards[7] = 8
        game.cards[8] = 8
        game.cards[9] = 6
        game.cards[10] = 7
        game.cards[11] = 2
        game.cards[12] = 3
        game.cards[13] = 4
        game.cards[14] = 3
        game.cards[15] = 4

        val expectedResult = 1
        val actualResult = game.countValuesInArray(5)

        Assertions.assertEquals(
            expectedResult,
            actualResult,
            "Donade les tarjetes [1,1,5,7,1,2,6,8,8,6,7,2,3,4,3,4] el número 5 només ha d'apareixer 1 vegada, en canvi surt $actualResult"
        )

    }

    @Test
    fun `Hi ha dos nombres iguals en tot l'array tarjetes`() {

        game.cards[0] = 5
        game.cards[1] = 1
        game.cards[2] = 5
        game.cards[3] = 7
        game.cards[4] = 1
        game.cards[5] = 2
        game.cards[6] = 6
        game.cards[7] = 8
        game.cards[8] = 8
        game.cards[9] = 6
        game.cards[10] = 7
        game.cards[11] = 2
        game.cards[12] = 3
        game.cards[13] = 4
        game.cards[14] = 3
        game.cards[15] = 4


        for (i in 1..8) {
            val expectedResult = 2
            val actualResult = game.countValuesInArray(i)
            Assertions.assertEquals(
                expectedResult,
                actualResult,
                "Donat el nombre $i ha d'apareixer 2 vegades, però hi ha $actualResult"
            )
        }


    }

    @Test
    fun `Hi ha tres nombres iguals en tot l'array tarjetes`() {
        game.cards[0] = 5
        game.cards[1] = 5
        game.cards[2] = 5
        game.cards[3] = 7
        game.cards[4] = 1
        game.cards[5] = 2
        game.cards[6] = 6
        game.cards[7] = 8
        game.cards[8] = 8
        game.cards[9] = 6
        game.cards[10] = 7
        game.cards[11] = 2
        game.cards[12] = 3
        game.cards[13] = 4
        game.cards[14] = 3
        game.cards[15] = 4


        val expectedResult = 3
        val actualResult = game.countValuesInArray(5)

        Assertions.assertEquals(
            expectedResult,
            actualResult,
            "Donat l'array [5,5,5,7,1,2,6,8,8,6,7,2,3,4,3,4] el nombre 5 apareix 3 vegades, però la funció retorna $actualResult"
        )

    }

    @Test
    fun `Tots els nombres son iguals`() {

        for (i in 0 until 16) {
            game.cards[i] = 2
        }
        val sameExpectedResult = 16
        val actualResult = game.countValuesInArray(2)
        Assertions.assertEquals(
            sameExpectedResult, actualResult,
            "Donat l'array [2,2,2,2,2,2,2,2,2,2,2,2,2,2,2] el nombre 2 apareix 16 vegades, però la funció retorna $actualResult"
        )
    }

    @Test
    fun `No existeix un valor a l'array`() {
        // test case for a number does not exist in the array
        for (i in 0 until 16) {
            game.cards[i] = i + 2
        }
        val notExistExpectedResult = 0
        val actualResult = game.countValuesInArray(1)
        Assertions.assertEquals(
            notExistExpectedResult, actualResult,
            "Donat l'array [2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18] el nombre 1 apareix 0 vegades, però la funció retorna $actualResult"
        )
    }


}