import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import cleanArchitecture.layerPresentation.Presentation
import cleanArchitecture.layerDomain.Interactor
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
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App(interactor: Interactor, presentation: Presentation) {

    AppTheme {
        Surface(color = Color.LightGray, modifier = Modifier.fillMaxSize()) {
            var showContent by remember { mutableStateOf(false) }

            var temp by remember { mutableStateOf(presentation.mutableLaunchesPresentation.value) }

            LaunchedEffect(""){
                presentation.mutableLaunchesPresentation.collectLatest{
                    temp=it
                }
            }
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Button(onClick = {
                    interactor.userActions.click()
                }) {
                    Text("temp")
                }

                LazyColumn(Modifier.fillMaxWidth()) {
                    items(temp.size) {
                        Row(Modifier.fillMaxWidth()) {
                            Card(modifier = Modifier.padding(6.dp).fillMaxWidth()) {
                                Column(modifier = Modifier.padding(10.dp)) {
                                    Row {
                                        Text(text = "${stringResource(Res.string.launch_name)}${temp[it].missionName}")
                                    }
                                    Row {
                                        Text(text = "${stringResource(Res.string.launch_success)}${temp[it].launchSuccess}")
                                    }
                                    Row {
                                        Text(text = "${stringResource(Res.string.launch_year)}${temp[it].launchDateUTC}")
                                    }
                                    Row {
                                        Text(text = "${stringResource(Res.string.launch_details)}${temp[it].details}")
                                    }
                                    Row(
                                        horizontalArrangement = Arrangement.End,
                                        modifier = Modifier.fillMaxWidth()) {
                                        var openUri by remember { mutableStateOf(false) }

                                        if (openUri) {

                                            listOf(
                                                "${temp[it].articleUrl}",
                                                "${temp[it].patchUrlLarge}",
                                                "${temp[it].patchUrlSmall}",
                                            )
                                                .forEach { stringLink->
                                                    LocalUriHandler.current.openUri(stringLink)
                                                }
                                            openUri=false
                                        }

                                        ClickableText(
                                            text = buildAnnotatedString {
                                                withStyle(style = SpanStyle(color = MaterialTheme.colors.primary)) {
                                                    append("More...")
                                                }
                                            },
                                            onClick = {openUri=true},
                                        )
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
}


