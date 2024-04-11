import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import cleanArchitecturePlusSOLID.Presentation.PresentationImpl
import cleanArchitecturePlusSOLID.data.RepositoryPlatformImpl
import cleanArchitecturePlusSOLID.domain.InteractorImpl

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