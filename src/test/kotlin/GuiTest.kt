package ad.cfp.memory.test

import ad.cfp.memory.Game
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.GridPane
import javafx.scene.layout.VBox
import javafx.stage.Stage

import org.testfx.framework.junit5.ApplicationTest
import org.testfx.framework.junit5.Start


open class GuiTest : ApplicationTest() {
    lateinit var scene: Scene
    lateinit var game: Game

    @Start
    override fun start(stage: Stage) {

        val gridPane = GridPane().apply {
            id = "board"
        }

        stage.apply {
            val root = VBox().apply {
                children.addAll(gridPane)
            }
            scene = Scene(root, 300.0, 300.0)
            game = Game(scene, gridPane)
            game.cards.fill(0)
            createButtons()
            this@GuiTest.scene = scene
        }
        stage.scene
    }

    fun createButtons() {
        // Supongamos que el juego tiene 4x4 tarjetas
        val totalCards = 16
        val cards = MutableList(totalCards) { index ->
            // Aquí crearías instancias de tu clase Tarjeta
            Button().apply { text = "" }
        }

        // Añadir tarjetas a la cuadrícula
        var cardIndex = 0
        for (i in 0..3) {
            for (j in 0..3) {
                game.board.add(cards[cardIndex], j, i)
                cardIndex++
            }
        }
    }

    fun getButtons(): List<Button> {
        return game.board.children.map { it as Button }.toList()
    }
}
