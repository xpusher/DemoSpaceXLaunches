package org.example.project

import App
import cleanArchitecture.layerPresentation.Presenter
import cleanArchitecture.layerData.Repository.RepositoryPlatformImpl
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import cleanArchitecture.layerData.Boundaries
import cleanArchitecture.layerDomain.Interactor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            val presenter=
                remember { Presenter() }

            val repository=
                remember {
                    RepositoryPlatformImpl(this)
                }
            val boundaries=
                remember {
                    Boundaries(repository)
                }
            val interactor=
                remember { Interactor(presenter, boundaries) }

            App(interactor,presenter)

        }
    }
}


