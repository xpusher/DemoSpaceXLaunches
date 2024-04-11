import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import cleanArchitecturePlusSOLID.Presentation.PresentationImpl
import cleanArchitecturePlusSOLID.data.RepositoryPlatformImpl
import cleanArchitecturePlusSOLID.domain.InteractorImpl

fun MainViewController() = ComposeUIViewController {

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