import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {

    val presentation=
        remember { PresentationImpl() }

    val repository=
        remember { RepositoryImpl() }

    val interactor=
        remember {
            InteractorImpl(presentation,repository)
        }

    App(interactor,presentation)
}