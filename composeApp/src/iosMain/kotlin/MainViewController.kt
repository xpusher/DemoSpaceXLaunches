import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import cleanArchitecture.layerData.Boundaries
import cleanArchitecture.layerPresentation.Presenter
import cleanArchitecture.layerData.Repository.RepositoryPlatformImpl
import cleanArchitecture.layerDomain.Interactor

fun MainViewController() = ComposeUIViewController {

    val presenter=
        remember { Presenter() }

    val repository=
        remember { RepositoryPlatformImpl() }

    val boundaries=
        remember {
            Boundaries(repository)
        }

    val interactor=
        remember {
            Interactor(presenter, boundaries)
        }

    App(interactor,presenter)
}