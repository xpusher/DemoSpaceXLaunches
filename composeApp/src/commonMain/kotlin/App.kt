import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cleanArchitecture.layerPresentation.Presentation
import cleanArchitecture.layerDomain.Interactor
import cleanArchitecture.toPresentationFromUTC
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.compose_multiplatform
import kotlinproject.composeapp.generated.resources.launch_details
import kotlinproject.composeapp.generated.resources.launch_name
import kotlinproject.composeapp.generated.resources.launch_year
import kotlinproject.composeapp.generated.resources.launches_title
import kotlinx.datetime.LocalDateTime
import org.jetbrains.compose.resources.stringResource
import androidx.compose.foundation.lazy.items

@OptIn(ExperimentalResourceApi::class, ExperimentalFoundationApi::class)
@Composable
@Preview
fun App(interactor: Interactor, presentation: Presentation) {
    AppTheme {
        Surface(color = Color.LightGray, modifier = Modifier.fillMaxSize()) {
            var showProgress by remember {
                mutableStateOf(false) }

            var currentRotation by remember { mutableStateOf(0f) }

            val launches by
                 presentation.mutableLaunchesPresentation.collectAsState()

            Column(Modifier.padding(6.dp).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

                Row {
                    Text(
                        text= stringResource(Res.string.launches_title),
                        textDecoration = TextDecoration.Underline)
                }

                @Composable
                fun showUpdateView(){
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth()) {
                        if(launches?.isNotEmpty()==true){
                            Text(
                                text = LocalDateTime.toPresentationFromUTC(LocalDateTime.parse(launches!![0].timestamp)),
                                fontSize = 12.sp)
                        }
                        Icon(
                            Icons.Filled.Refresh,
                            "",
                            modifier = Modifier.clickable {
                                interactor.userActions.hardUpdateLaunches()
                                showProgress=true
                            })

                    }

                }

                when(launches?.size){
                    null->{
                        Text("QQQQ")
                        showProgress=true
                        val rotation = remember { Animatable(currentRotation) }
                        LaunchedEffect(showProgress){
                            rotation.animateTo(
                                targetValue = currentRotation + 360f,
                                animationSpec = infiniteRepeatable(
                                    animation = tween(3000, easing = LinearEasing),
                                    repeatMode = RepeatMode.Restart
                                )
                            ) {
                                currentRotation = value
                            }
                        }
                        AnimatedVisibility(showProgress) {
                            val greeting = remember { Greeting().greet() }
                            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                                Image(
                                    painterResource(Res.drawable.compose_multiplatform),
                                    null,
                                    modifier = Modifier.rotate(currentRotation))
                                Text("Compose: $greeting")
                            }
                        }

                    }
                    0->{
                        showUpdateView()
                        showProgress=false
                    }
                    else->{
                        showUpdateView()
                        showProgress=false
                        LazyColumn(Modifier.fillMaxWidth()) {
                            launches?.let {launches->
                                items(launches,key={it.flightNumber}) { launch->
                                    Row(Modifier.fillMaxWidth().animateItemPlacement(tween(durationMillis = 500))) {
                                        Card(modifier = Modifier
                                            .padding(bottom = 2.dp)
                                            .fillMaxWidth()) {
                                            Column(modifier = Modifier.padding(10.dp)) {
                                                Row(
                                                    horizontalArrangement = Arrangement.End,
                                                    modifier = Modifier.fillMaxWidth()) {
                                                    Icon(
                                                        Icons.Filled.Close,
                                                        "",
                                                        modifier = Modifier.clickable {
                                                            interactor.userActions.removeLaunches(launch.flightNumber)
                                                        })
                                                }
                                                Row {
                                                    Text(text = "${stringResource(Res.string.launch_name)}${launch.missionName}")
                                                }
                                                Row(verticalAlignment = Alignment.CenterVertically) {
                                                    Text(
                                                        text = textBoolPresentation(launch.launchSuccess),
                                                        style = textStyleBoolColorPresentation(launch.launchSuccess))
                                                }
                                                Row {
                                                    Text(text = "${stringResource(Res.string.launch_year)}${launch.launchDateUTC}")
                                                }
                                                Row {
                                                    Text(text = "${stringResource(Res.string.launch_details)}${launch.details}")
                                                }
                                                Row(
                                                    horizontalArrangement = Arrangement.End,
                                                    modifier = Modifier.fillMaxWidth()) {
                                                    var openUri by remember { mutableStateOf(false) }

                                                    if (openUri) {

                                                        listOf(
                                                            launch.articleUrl,
                                                            launch.patchUrlLarge,
                                                            launch.patchUrlSmall,
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

                        }
                    }
                }

            }

        }

    }

}


