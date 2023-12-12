package ad.cfp.memory.test

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class Exercici1Test : GuiTest() {


    @Test
    fun `El número generat està entre 1 i 8`() {
        val number = game.generateRandomNumber()
        assertTrue(number in 1..8, "Number should be between 1 and 8")
    }

    @Test
    fun `distribution test`() {
        val counts = IntArray(8)
        val totalRuns = 10000

        for (i in 1..totalRuns) {
            val number = game.generateRandomNumber()
            counts[number - 1]++
        }

        for (count in counts) {
            assertTrue(count > (totalRuns / 8 * 0.5), "La freqüència de $count és massa baixa")
            assertTrue(count < (totalRuns / 8 * 1.5), "La freqüència de $count és massa alta")
        }
    }

}