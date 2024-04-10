import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "KotlinProject") {
        val presentation=
            remember { PresentationImpl() }
        val mainApp=
            remember { DomainImpl(presentation)}

        App(mainApp.interactor,presentation)
    }
}