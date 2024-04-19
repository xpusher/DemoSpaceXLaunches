import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import cleanArchitecture.layerData.Boundaries
import cleanArchitecture.layerPresentation.Presenter
import cleanArchitecture.layerData.Repository.RepositoryPlatformImpl
import cleanArchitecture.layerDomain.Interactor
import cleanArchitecture.layerDomain.entity.LaunchPresentation
import cleanArchitecture.nowUTC
import kotlinx.datetime.LocalDateTime

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "KotlinProject") {

        val presenter=
            remember { Presenter() }

        val interactor=
            remember {
                Interactor(
                    presenter,
                    Boundaries(RepositoryPlatformImpl()))
            }

        App(interactor,presenter)
    }
}

@Preview
@Composable
fun AppAndroidPreview() {

    AppTheme {
        App(
            null,
            Presenter()
                .apply {
                mutableLaunchesPresentation.value =
                    ArrayList<LaunchPresentation>()
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
                                        timestamp = LocalDateTime.nowUTC().toString()
                                    )
                                )
                            }
                        } })
    }

}

