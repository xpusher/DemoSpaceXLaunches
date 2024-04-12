import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import cleanArchitecture.layerData.Boundaries
import cleanArchitecture.layerPresentation.Presentation
import cleanArchitecture.layerData.Repository.RepositoryPlatformImpl
import cleanArchitecture.layerDomain.Interactor
import cleanArchitecture.layerPresentation.LaunchPresentation
import com.example.Launch

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "KotlinProject") {
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

@Preview
@Composable
fun AppAndroidPreview() {

    val presentation=
        remember { Presentation().apply {
            mutableLaunchesPresentation.value = ArrayList<LaunchPresentation>()
                .apply {
                    repeat(3) {
                        add(
                            LaunchPresentation(
                                flightNumber = 0,
                                missionName = "dfd",
                                details = "sdsd",
                                launchSuccess = it%2==0,
                                launchDateUTC = "2006-03-24T22:30:00.000Z",
                                "null",
                                "null",
                                "null",
                            )
                        )
                    }
                }

        } }

    val repository= remember {
        RepositoryPlatformImpl()
    }

    val boundaries=
        remember {
            Boundaries(repository)
        }

    val interactor=
        remember {
            Interactor(presentation, boundaries)
        }

    App(interactor,presentation)

//    Text(text = "sdsdsd")
}

