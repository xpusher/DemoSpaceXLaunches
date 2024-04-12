import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import cleanArchitecture.layerData.Boundaries
import cleanArchitecture.layerPresentation.Presentation
import cleanArchitecture.layerData.Repository.RepositoryPlatformImpl
import cleanArchitecture.layerDomain.Interactor

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