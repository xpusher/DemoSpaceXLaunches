package org.example.project

import App
import cleanArchitecturePlusSOLID.layerPresentation.PresentationImpl
import cleanArchitecturePlusSOLID.layerData.Repository.RepositoryPlatformImpl
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import cleanArchitecturePlusSOLID.layerDomain.InteractorImpl
import cleanArchitecturePlusSOLID.layerDomain.entity.Links
import cleanArchitecturePlusSOLID.layerDomain.entity.RocketLaunch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            val presentation=
                remember { PresentationImpl() }

            val repository=
                remember {
                    RepositoryPlatformImpl(this)
                }

            val interactor=
                remember { InteractorImpl(presentation, repository) }

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
        remember { PresentationImpl().apply {
            mutableRocketLaunches.value= listOf(
                RocketLaunch(
                    flightNumber = 0,
                    missionName = "dfd",
                    details = "sdsd",
                    launchSuccess = true,
                    launchDateUTC = "2006-03-24T22:30:00.000Z",
                    links = Links(null,null)
                )
            )

        } }

        val repository= remember {
            RepositoryPlatformImpl(context)
        }

    val interactor=
        remember {
            InteractorImpl(presentation, repository)
        }
    App(interactor,presentation)

//    Text(text = "sdsdsd")
}