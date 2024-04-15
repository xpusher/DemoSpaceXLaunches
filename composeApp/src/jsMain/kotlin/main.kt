import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import cleanArchitecture.layerData.Boundaries
import cleanArchitecture.layerPresentation.Presentation
import cleanArchitecture.layerData.Repository.RepositoryPlatformImpl
import cleanArchitecture.layerDomain.Interactor
import io.kamel.core.config.DefaultCacheSize
import io.kamel.core.config.KamelConfig
import io.kamel.core.config.fileFetcher
import io.kamel.core.config.httpFetcher
import io.kamel.core.config.takeFrom
import io.kamel.image.config.Default
import io.kamel.image.config.LocalKamelConfig
import io.kamel.image.config.imageBitmapDecoder
import io.kamel.image.config.imageVectorDecoder
import io.kamel.image.config.svgDecoder
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.http.HttpMethod
import io.ktor.http.isSuccess
import io.ktor.util.logging.LogLevel

@OptIn(ExperimentalComposeUiApi::class)
fun main() {

    CanvasBasedWindow(canvasElementId = "ComposeTarget") {
        val customKamelConfig =
        CompositionLocalProvider(
            LocalKamelConfig provides KamelConfig {
                takeFrom(KamelConfig.Default)
                imageBitmapCacheSize = DefaultCacheSize
                imageBitmapDecoder()
                imageVectorDecoder()
                svgDecoder()
                fileFetcher()
                httpFetcher {
                    defaultRequest {}
                }
            }){
            val presentation=
                remember { Presentation() }

            val repository=
                remember { RepositoryPlatformImpl() }

            val boundaries=
                remember {
                    Boundaries(repository)
                }

            val interactor=
                remember {
                    Interactor(presentation, boundaries)
                }

            App(interactor,presentation)

        }

    }
}