
import ad.cfp.memory.test.GuiTest
import javafx.scene.control.Button
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Exercici5Test : GuiTest() {

    @Test
    fun `Escriure un element a un botó`() {
        val buttons = getButtons()
        game.fillArray()
        game.writeNumberInButton(buttons[0], 0)
        val expected = game.cards[0].toString()
        assertEquals(buttons[0].text, expected)
    }

    @Test
    fun `Escriure dos vegades al mateix botó`() {
        val buttons = getButtons()
        game.fillArray()

        val firstButton = buttons[0]
        val firstCard = game.cards[0]

        game.writeNumberInButton(firstButton, 0)

        val expected = firstCard.toString()
        assertEquals(firstButton.text, expected)

        writeNumberOnDifferentCard(firstButton, firstCard)

        assertEquals(firstButton.text, expected)
    }

    fun writeNumberOnDifferentCard(button: Button, firstCard: Int) {
        for (i in 1..8) {
            if (firstCard != game.cards[i]) {
                game.writeNumberInButton(button, i)
                break
            }
        }
    }


}