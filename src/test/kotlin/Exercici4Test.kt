import ad.cfp.memory.test.GuiTest
import org.junit.jupiter.api.Test

class Exercici4Test : GuiTest() {
    @Test
    fun `La funció fillArray especifica un valor aleatori per cada tarjeta`() {
        game.fillArray()
        assert(
            game.cards.none { it == 0 },
            { "Al executar la funció fillArray totes les posicions del array han de contenir dades" })
    }

    @Test
    fun `La funció fillArray especifica un valor aleatori per cada i cada valor existeix només dues vegades`() {
        game.fillArray()
        assert(game.cards.none { it == 0 })
        val map = game.cards.groupBy { it }.mapValues { (_, value) -> value.size }
        val allElementsAppearTwice = map.values.all { it == 2 }
        assert(
            allElementsAppearTwice,
            { "Al utilitzar la funció fillArray cada valor del array només pot estar repetit 2 vegades" }
        )
    }
}