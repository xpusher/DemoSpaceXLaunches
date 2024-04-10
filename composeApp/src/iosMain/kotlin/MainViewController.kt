import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {

    val presentation=
        remember { PresentationImpl() }
    val mainApp=
        remember { DomainImpl(presentation)}

    App(mainApp.interactor,presentation)
}