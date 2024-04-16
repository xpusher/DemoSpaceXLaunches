import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import cleanArchitecture.layerData.Boundaries
import cleanArchitecture.layerPresentation.Presentation
import cleanArchitecture.layerData.Repository.RepositoryPlatformImpl
import cleanArchitecture.layerDomain.Interactor

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow(canvasElementId = "ComposeTarget") {
        CompositionLocalProvider{

            val presentation=
                remember { Presentation() }

            val repository=
                remember { RepositoryPlatformImpl() }

            val boundaries=
                remember {
                    Boundaries(repository) }

            val interactor=
                remember {
                    Interactor(presentation, boundaries) }

            App(interactor,presentation)

        }
    }
}