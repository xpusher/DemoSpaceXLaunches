import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import cleanArchitecturePlusSOLID.layerData.Boundaries
import cleanArchitecturePlusSOLID.layerPresentation.Presentation
import cleanArchitecturePlusSOLID.layerData.Repository.RepositoryPlatformImpl
import cleanArchitecturePlusSOLID.layerDomain.Interactor

@OptIn(ExperimentalComposeUiApi::class)
fun main() {

    CanvasBasedWindow(canvasElementId = "ComposeTarget") {

        val presentation=
            remember { Presentation() }

        val repository=
            remember { RepositoryPlatformImpl() }

        val boundaries=
            remember {
                Boundaries(repository)
            }

        val interactor=
            remember {
                Interactor(presentation, boundaries)
            }

        App(interactor,presentation)

    }
}