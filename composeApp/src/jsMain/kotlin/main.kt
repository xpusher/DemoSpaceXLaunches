import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import cleanArchitecturePlusSOLID.layerPresentation.PresentationImpl
import cleanArchitecturePlusSOLID.layerData.Repository.RepositoryPlatformImpl
import cleanArchitecturePlusSOLID.layerDomain.InteractorImpl

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