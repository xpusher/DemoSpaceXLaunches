import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import cleanArchitecturePlusSOLID.layerData.Boundaries
import cleanArchitecturePlusSOLID.layerPresentation.Presentation
import cleanArchitecturePlusSOLID.layerData.Repository.RepositoryPlatformImpl
import cleanArchitecturePlusSOLID.layerDomain.Interactor

fun MainViewController() = ComposeUIViewController {

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