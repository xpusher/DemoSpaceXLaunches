package org.example.project

import App
import cleanArchitecturePlusSOLID.layerPresentation.Presentation
import cleanArchitecturePlusSOLID.layerData.Repository.RepositoryPlatformImpl
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import cleanArchitecturePlusSOLID.layerData.Boundaries
import cleanArchitecturePlusSOLID.layerDomain.Interactor
import cleanArchitecturePlusSOLID.layerDomain.entity.Links
import cleanArchitecturePlusSOLID.layerDomain.entity.RocketLaunch
import com.example.Launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            val presentation=
                remember { Presentation() }

            val repository=
                remember {
                    RepositoryPlatformImpl(this)
                }
            val boundaries=
                remember {
                    Boundaries(repository)
                }
            val interactor=
                remember { Interactor(presentation, boundaries) }

            App(interactor,presentation)

        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {

    val context=
        LocalContext.current

    val presentation=
        remember { Presentation().apply {
            mutableRocketLaunches.value= listOf(
                Launch(
                    flightNumber = 0,
                    missionName = "dfd",
                    details = "sdsd",
                    launchSuccess = null,
                    launchDateUTC = "2006-03-24T22:30:00.000Z",
                    null,
                    null,
                    null,
                )
            )

        } }

        val repository= remember {
            RepositoryPlatformImpl(context)
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