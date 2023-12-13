package ad.cfp.memory

import javafx.event.EventHandler
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.input.MouseEvent
import javafx.scene.layout.GridPane
import javafx.scene.layout.VBox
import javafx.stage.Popup
import org.kordamp.bootstrapfx.BootstrapFX
import kotlin.random.Random

class Game(val scene: Scene, val board: GridPane) {
    var pendingCards = 8
    var rotateCard = 0
    var lastButton: Button? = null
    val cards = IntArray(16).map { 0 }.toIntArray()


    private fun showMessageWinner() {
        val popup = Popup()

        // Crear el contenido del Popup
        // Crear el contenido del Popup
        val popupContent = VBox(10.0).apply {
            stylesheets.add(BootstrapFX.bootstrapFXStylesheet())
            styleClass.add("popup-content")
            style += "-fx-background-color: #f8f9fa;"
            style += "-fx-border-color: #adb5bd;"
            style += "-fx-border-width: 2;"
            style += "-fx-padding: 10;"
        }

        val label = Label("Felicitats has guanyat")
        val closeButton = Button("Tancar").apply {
            maxWidth = Double.MAX_VALUE
        }
        closeButton.onAction = EventHandler {
            popup.hide()
            resetBoard()
        }

        popupContent.getChildren().addAll(label, closeButton);

        popup.getContent().add(popupContent);

        val closePopupHandler: EventHandler<MouseEvent> = EventHandler<MouseEvent> { event: MouseEvent ->
            if (!popup.isShowing) {
                return@EventHandler
            }
            val eventTarget: Node = event.getTarget() as Node
            if (!popup.content.contains(eventTarget)) {
                popup.hide()
            }
        }
        scene.addEventFilter(MouseEvent.MOUSE_PRESSED, closePopupHandler)


        val x = scene.window.x + (scene.width / 2 - 83.75)
        val y = scene.window.y + scene.height / 2
        popup.show(scene.window, x, y)
    }

    fun getButtons() = board.children.map { it as Button }.toList()


    init {
        try {
            fillArray()
        } catch (_: NotImplementedError) { }
    }

    /**
     * Funció per generar números aleatoris entre 1 i 8
     *
     * @return Int número aleatori generat
     */
    fun generateRandomNumber(): Int {
        throw NotImplementedError("Encara no s'ha implementat aquesta funció")
    }

    /**
     * Compta el nombre d'ocurrències d'un valor donat a l'array.
     *
     * @param value El valor a comptar.
     * @return El número d'ocurrències del valor a l'array.
     */
    fun countValuesInArray(value: Int): Int {
        throw NotImplementedError("Encara no s'ha implementat aquesta funció")
    }

    /**
     * Donada una posició especifica, ha de generar un nombre aleatori.
     * Si aquest número generat existeix en l'array dues vegades, ha de generar un altre.
     * El procés es durà a terme fins a trobar-ne un que no estigui dues vegades.
     *
     * @param pos La posició on es pot afegir el número.
     */
    fun addNumberInArray(pos: Int) {
        throw NotImplementedError("Encara no s'ha implementat aquesta funció")
    }

    /**
     * Ompla l'array `cards` amb números aleatoris entre 1 i 8. Si un nombre
     * ja existeix dues vegades a l'array, es genera un nou número aleatori per
     * a aquesta posició.
     */
    fun fillArray() {
        throw NotImplementedError("Encara no s'ha implementat aquesta funció")
    }


    /**
     * Escriu el número al botó donat si el seu text és buit i estableix el
     * text al valor a la posició especificada a l'array `tarjetes`.
     *
     * @param button El botó a girar.
     * @param pos La posició a l'array `tarjetes` des d'on obtenir el valor.
     */
    fun writeNumberInButton(button: Button, pos: Int) {
        throw NotImplementedError("Encara no s'ha implementat aquesta funció")
    }

    /**
     * Juga el joc girant un botó i comprovant la coincidència. El gir del
     * botó es realitza de forma automàtica, no cal realitzar-lo Sí que
     * s'ha d'establir el text al botó, si dos targetes no són iguals s'han
     * d'eliminar els textos
     *
     * IMPORTANT:
     * - Comprovar si és la primera o segona tarjeta que girem, ens podem
     *   ajudar amb les variables
     *    - currentTurn, en la que guardarem el valor de la tarjeta girada
     *    - lastButton, en la que guardarem el valor de l'última tarjeta girada
     * - Sí, dos tarjetes són iguals, reduïr pendindCards, si no queden
     *   targetes mostrar missatge de guanyador.
     * - En cas contrari restablir el text dels botons a ""
     *
     * @param button El botó a jugar.
     * @param pos La posició del botó a l'array.
     */
    fun play(button: Button, pos: Int) {

        throw NotImplementedError("Encara no s'ha implementat aquesta funció")
    }


    /**
     * Reinicia el tauler del joc establint la variable pendingCards a 8 i
     * esborrant el text de cada botó del tauler. També reinicia les variables
     * currentTurn i lastButton als seus valors inicials. Finalment, omple
     * l'array tarjetes amb nombres aleatoris entre 1 i 8, assegurant-se que
     * cada número només apareix dues vegades (fillArray).
     */
    fun resetBoard() {
        throw NotImplementedError("Encara no s'ha implementat aquesta funció")
    }

}
