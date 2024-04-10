import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow

@OptIn(ExperimentalComposeUiApi::class)
fun main() {

    CanvasBasedWindow(canvasElementId = "ComposeTarget") {

        val presentation=
            remember { PresentationImpl() }

        val repository=
            remember { RepositoryImpl() }

        val interactor=
            remember {
                InteractorImpl(presentation,repository)
            }

        App(interactor,presentation)

    }
}