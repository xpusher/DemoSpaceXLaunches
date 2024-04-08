import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow(canvasElementId = "ComposeTarget") {
        val repositoryImpl=RepositoryImpl()
        val presentation=PresentationImpl()
        App(UserActionImpl(repositoryImpl,presentation),presentation)
    }
}