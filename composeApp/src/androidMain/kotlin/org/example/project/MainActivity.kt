package org.example.project

import App
import cleanArchitecture.layerPresentation.Presentation
import cleanArchitecture.layerData.Repository.RepositoryPlatformImpl
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import cleanArchitecture.layerData.Boundaries
import cleanArchitecture.layerDomain.Interactor
import cleanArchitecture.layerDomain.entity.Links
import cleanArchitecture.layerDomain.entity.RocketLaunch
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


