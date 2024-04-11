import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import cleanArchitecturePlusSOLID.layerPresentation.PresentationImpl
import cleanArchitecturePlusSOLID.layerData.Repository.RepositoryPlatformImpl
import cleanArchitecturePlusSOLID.layerDomain.InteractorImpl

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "KotlinProject") {
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