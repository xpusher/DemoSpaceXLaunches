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
                    // httpCache is defined in kamel-core and configures the ktor client
                    // to install a HttpCache feature with the implementation provided by Kamel.
                    // The size of the cache can be defined in Bytes.
//                    httpCache(10 * 1024 * 1024  /* 10 MiB */)

                    defaultRequest {

//                        url("https://www.example.com/")
//                        cacheControl(CacheControl.MaxAge(maxAgeSeconds = 10000))
                        //headers["Access-Control-Allow-Origin"] = "*"
//                        headers["Accept"] = "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8"
//                        headers["Host"] = "images2.imgbox.com"
//                        headers["Sec-Fetch-Mode"] = "no-cors"
//                        headers["Sec-Fetch-Site"] = "cross-site"
//                        headers["Sec-Fetch-Dest"] = "image"

//                        headers["Access-Control-Allow-Origin"] = "*"
//                        headers["Access-Control-Allow-Methods"] = "*"
//                        headers["Access-Control-Allow-Headers"] = "*"
//                        headers["QQQQ"] = "qq"
//                        headers["Sec-Fetch-Mode"] = "no-cors"
//                        headers["Sec-Fetch-Site"] = "cross-site"
//                        headers["Sec-Fetch-Dest"] = "image"

                    }

//                    install(HttpRequestRetry) {
//                        maxRetries = 3
//                        retryIf { httpRequest, httpResponse ->
//                            !httpResponse.status.isSuccess()
//                        }
//                    }

                    // Requires adding "io.ktor:ktor-client-logging:$ktor_version"
                    Logging {
                        level = io.ktor.client.plugins.logging.LogLevel.INFO
                        logger = Logger.SIMPLE
                    }
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