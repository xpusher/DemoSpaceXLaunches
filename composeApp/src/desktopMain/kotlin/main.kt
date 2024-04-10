import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "KotlinProject") {
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
}