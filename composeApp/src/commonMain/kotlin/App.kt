import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cleanArchitecturePlusSOLID.Presentation.Presentation
import cleanArchitecturePlusSOLID.domain.entity.RocketLaunch
import cleanArchitecturePlusSOLID.domain.usecase.UserActions
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.compose_multiplatform
import kotlinproject.composeapp.generated.resources.launch_details
import kotlinproject.composeapp.generated.resources.launch_name
import kotlinproject.composeapp.generated.resources.launch_success
import kotlinproject.composeapp.generated.resources.launch_year
import kotlinx.coroutines.flow.collectLatest
import org.jetbrains.compose.resources.getString
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App(interactorImpl: InteractorImpl) {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }

        var temp by remember { mutableStateOf<List<RocketLaunch>>(listOf()) }

        LaunchedEffect(""){
            interactorImpl.presentation.mutableRocketLaunches.collectLatest{
                temp=it
            }
        }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                interactorImpl.userActions.click()
            }) {
                Text("temp")
            }

            LazyColumn(Modifier.fillMaxWidth()) {
                items(temp.size) {
                    Row(Modifier.fillMaxWidth()) {
                        Card(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
                            Column {
                                Row {
                                    Text(text = "${stringResource(Res.string.launch_name)}${temp[it].missionName}")
                                }
                                Row {
                                    Text(text = "${stringResource(Res.string.launch_success)}${temp[it].launchSuccess}")
                                }
                                Row {
                                    Text(text = "${stringResource(Res.string.launch_year)}${temp[it].launchYear}")
                                }
                                Row {
                                    Text(text = "${stringResource(Res.string.launch_details)}${temp[it].details}")
                                }
                            }
                        }
                    }
                }
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