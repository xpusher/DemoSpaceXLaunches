import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import cleanArchitecturePlusSOLID.layerPresentation.PresentationImpl
import cleanArchitecturePlusSOLID.layerData.Repository.RepositoryPlatformImpl
import cleanArchitecturePlusSOLID.layerDomain.InteractorImpl

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