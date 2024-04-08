import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {
    val repositoryImpl=RepositoryImpl()
    val presentation=PresentationImpl()
    App(UserActionImpl(repositoryImpl,presentation),presentation)
}