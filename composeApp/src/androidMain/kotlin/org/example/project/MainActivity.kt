package org.example.project

import App
import InteractorImpl
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import cleanArchitecturePlusSOLID.domain.entity.Links
import cleanArchitecturePlusSOLID.domain.entity.RocketLaunch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            val interactor=
                remember { InteractorImpl(this)}

            App(interactor)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {

    val context=
        LocalContext.current

    val interactor=
        remember {
            InteractorImpl(context).apply {
                presentation.mutableRocketLaunches.value= listOf(
                    RocketLaunch(
                        flightNumber = 0,
                        missionName = "dfd",
                        details = "sdsd",
                        launchSuccess = true,
                        launchDateUTC = "2006-03-24T22:30:00.000Z",
                        links = Links(null,null)
                    )
                )

            }
        }
    App(interactor)

//    Text(text = "sdsdsd")
}