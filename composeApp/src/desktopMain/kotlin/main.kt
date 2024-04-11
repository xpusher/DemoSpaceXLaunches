import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import cleanArchitecturePlusSOLID.layerData.Boundaries
import cleanArchitecturePlusSOLID.layerPresentation.Presentation
import cleanArchitecturePlusSOLID.layerData.Repository.RepositoryPlatformImpl
import cleanArchitecturePlusSOLID.layerDomain.Interactor

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "KotlinProject") {
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