import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "KotlinProject") {
        val repositoryImpl=RepositoryImpl()
        val presentationImpl=PresentationImpl()
        App(
            userActions = UserActionImpl(repositoryImpl,presentationImpl),
            presentation = presentationImpl)
    }
}