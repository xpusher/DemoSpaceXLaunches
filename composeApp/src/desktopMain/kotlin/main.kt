import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "KotlinProject") {
        val repositoryImpl=RepositoryImpl()
        App(repositoryImpl,UserActionImpl(repositoryImpl.sqlDriver))
    }
}