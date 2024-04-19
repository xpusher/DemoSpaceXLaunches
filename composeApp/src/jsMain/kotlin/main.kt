import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import cleanArchitecture.layerData.Boundaries
import cleanArchitecture.layerPresentation.Presenter
import cleanArchitecture.layerData.Repository.RepositoryPlatformImpl
import cleanArchitecture.layerDomain.Interactor

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow("ComposeTarget") {

        val isMobile=js("""
            /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent)
        """).toString().toBoolean()

        val presenter=
            remember { Presenter(if (isMobile) 1.3f else 1f) }

        val repository=
            remember { RepositoryPlatformImpl() }

        val boundaries=
            remember {
                Boundaries(repository) }

        val interactor=
            remember {
                Interactor(presenter, boundaries) }

        App(interactor,presenter)

    }
}