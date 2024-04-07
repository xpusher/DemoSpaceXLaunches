import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {
    val repositoryImpl=RepositoryImpl()
    App(repositoryImpl,UserActionImpl(repositoryImpl.sqlDriver))
}