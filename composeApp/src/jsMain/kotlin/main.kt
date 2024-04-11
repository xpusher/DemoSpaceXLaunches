import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import cleanArchitecturePlusSOLID.Presentation.PresentationImpl
import cleanArchitecturePlusSOLID.data.RepositoryPlatformImpl
import cleanArchitecturePlusSOLID.domain.InteractorImpl

@OptIn(ExperimentalComposeUiApi::class)
fun main() {

    CanvasBasedWindow(canvasElementId = "ComposeTarget") {

        val presentation=
            remember { PresentationImpl() }

        val repository=
            remember { RepositoryPlatformImpl() }

        val interactor=
            remember {
                InteractorImpl(presentation, repository)
            }

        App(interactor,presentation)

    }
}