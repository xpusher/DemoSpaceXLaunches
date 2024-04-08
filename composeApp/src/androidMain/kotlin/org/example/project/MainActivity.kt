package org.example.project

import App
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
            val repository= remember { RepositoryImpl(this) }
            val userAction= remember { UserActionImpl(repository.mutableSqlDriver) }
            App(repository,userAction)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
     val repository= RepositoryImpl(LocalContext.current)
    App(repository,UserActionImpl(repository.mutableSqlDriver))
}