package ad.cfp.memory

import javafx.animation.RotateTransition
import javafx.application.Application
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.*
import javafx.scene.text.Text
import javafx.scene.transform.Rotate
import javafx.stage.Stage
import javafx.util.Duration
import org.kordamp.bootstrapfx.BootstrapFX


class MemeryApplication : Application() {

    private lateinit var game: Game

    private val title = StackPane(Text("Joc del Memorama").apply {
        styleClass.addAll("text-primary", "h1")
    })

    private val grid = GridPane().apply {
        hgap = 10.0
        vgap = 10.0
        id = "board";
    }

    fun setMargins() {
        VBox.setMargin(title, Insets(30.0, 0.0, 30.0, 0.0))
        VBox.setMargin(grid, Insets(40.0))
    }

    fun createButtons(){
        // Supongamos que el juego tiene 4x4 tarjetas
        val totalCards = 16
        val cards = MutableList(totalCards) { index ->
            // Aquí crearías instancias de tu clase Tarjeta
            createButton(index)
        }


        // Añadir tarjetas a la cuadrícula
        var cardIndex = 0
        for (i in 0..3) {
            for (j in 0..3) {
                grid.add(cards[cardIndex], j, i)
                cardIndex++
            }
        }
    }

    fun createButton(pos: Int) = Button().apply {
        text = ""
        setOnAction {
            flipCard(this, pos)
        }
        styleClass.add("btn-primary")
        minHeight = 100.0
        minWidth = 100.0
    }

    override fun start(stage: Stage) {


        createButtons()
        setMargins()
        val root = VBox().apply {
            children.addAll(title, grid)
        }


        // Configuración de la ventana
        stage.apply {
            scene = Scene(root, 500.0, 650.0).apply {
                stylesheets.add(BootstrapFX.bootstrapFXStylesheet());
            }
            title = "Memorama"
            game = Game(scene,grid)
            show()
        }
    }

    private fun flipCard(card: Button, pos: Int) {
        if (card.text.isNotEmpty())
            return
        game.writeNumberInButton(card, pos)
        val rotateTransition = RotateTransition(Duration.millis(300.0), card)
        rotateTransition.axis = Rotate.Y_AXIS
        rotateTransition.toAngle = (if (card.rotate == 0.0) 360 else 0).toDouble()
        rotateTransition.play()
        rotateTransition.setOnFinished {
            Thread.sleep(200)
            game.play(card, pos)
        }

    }
}

fun main() {
    Application.launch(MemeryApplication::class.java)
}