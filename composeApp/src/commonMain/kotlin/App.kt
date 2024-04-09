import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cleanArchitecturePlusSOLID.Presentation.Presentation
import cleanArchitecturePlusSOLID.domain.usecase.UserActions
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.compose_multiplatform
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App(userActions: UserActions,presentation: Presentation) {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }

        var tempText by remember { mutableStateOf("init") }

        LaunchedEffect(""){
            presentation.mutableTestString.collectLatest{
                tempText="$it"
            }
        }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                userActions.click()
            }) {
                Text(tempText)
            }
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
}