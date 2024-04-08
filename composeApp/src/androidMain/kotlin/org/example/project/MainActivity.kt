package org.example.project

import App
import PresentationImpl
import RepositoryImpl
import UserActionImpl
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            val presentation=PresentationImpl()
            val userAction= remember {
                UserActionImpl(RepositoryImpl(this),presentation) }
            App(userAction,presentation)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    val presentation=PresentationImpl()
    App(UserActionImpl(RepositoryImpl(LocalContext.current),presentation),presentation)
}