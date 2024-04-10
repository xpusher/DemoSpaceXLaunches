import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow

@OptIn(ExperimentalComposeUiApi::class)
fun main() {

    CanvasBasedWindow(canvasElementId = "ComposeTarget") {
        val presentation=
            remember { PresentationImpl() }
        val mainApp=
            remember { DomainImpl(presentation)}

        App(mainApp.interactor,presentation)
    }
}