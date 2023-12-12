package ad.cfp.memory.test

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

        Assertions.assertEquals(expectedResult, actualResult)
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

        val expectedResult = 2
        val actualResult = game.countValuesInArray(5)

        Assertions.assertEquals(expectedResult, actualResult)
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

        // now we test it
        val expectedResult = 3
        val actualResult = game.countValuesInArray(5)

        Assertions.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Tots els nombres son iguals`() {

        for (i in 0 until 16) {
            game.cards[i] = 2
        }
        val sameExpectedResult = 16
        val sameActualResult = game.countValuesInArray(2)
        Assertions.assertEquals(sameExpectedResult, sameActualResult)
    }

    @Test
    fun `No existeix un valor a l'array`() {
        // test case for a number does not exist in the array
        for (i in 0 until 16) {
            game.cards[i] = i + 2
        }
        val notExistExpectedResult = 0
        val notExistActualResult = game.countValuesInArray(1)
        Assertions.assertEquals(notExistExpectedResult, notExistActualResult)
    }


}