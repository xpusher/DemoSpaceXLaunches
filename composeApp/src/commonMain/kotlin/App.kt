import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
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
import kotlinx.coroutines.flow.collectLatest
import kotlinx.datetime.LocalDateTime
import org.jetbrains.compose.resources.stringResource


@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App(interactor: Interactor, presentation: Presentation) {
    AppTheme {
        Surface(color = Color.LightGray, modifier = Modifier.fillMaxSize()) {
            var showProgress by remember {
                mutableStateOf(false) }

            var launchesPresentation by remember {
                mutableStateOf(presentation.mutableLaunchesPresentation.value) }

            LaunchedEffect(""){
                presentation.mutableLaunchesPresentation.collectLatest{
                    launchesPresentation=it
                }
            }
            Column(Modifier.padding(6.dp).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                @Composable
                fun showUpdateView(){
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth()) {
                        if(launchesPresentation?.isNotEmpty()==true){
                            Text(
                                text = LocalDateTime.toPresentationFromUTC(LocalDateTime.parse(launchesPresentation!![0].timestamp)),
                                fontSize = 12.sp)
                        }
                        Icon(
                            Icons.Filled.Refresh,
                            "",
                            modifier = Modifier.clickable {
                                interactor.userActions.updateLaunches()
                                showProgress=true
                            })

                    }

                }
                when{
                    launchesPresentation==null->{

                        interactor.userActions.loadLaunches()

                        showProgress=true

                        AnimatedVisibility(showProgress) {
                            val greeting = remember { Greeting().greet() }
                            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                                Image(painterResource(Res.drawable.compose_multiplatform), null)
                                Text("Compose: $greeting")
                            }
                        }

                    }
                    launchesPresentation?.isEmpty()==true->{
                        showUpdateView()
                        showProgress=true
                    }
                    else->{
                        showUpdateView()
                        showProgress=true
                        LazyColumn(Modifier.fillMaxWidth()) {
                            launchesPresentation?.let {launchesPresentation->
                                items(launchesPresentation.size) {
                                    Row(Modifier.fillMaxWidth()) {
                                        Card(modifier = Modifier.padding(bottom = 2.dp).fillMaxWidth()) {
                                            Column(modifier = Modifier.padding(10.dp)) {
                                                Row {
                                                    Text(text = "${stringResource(Res.string.launch_name)}${launchesPresentation[it].missionName}")
                                                }
                                                Row(verticalAlignment = Alignment.CenterVertically) {
                                                    Text(
                                                        text = textBoolPresentation(launchesPresentation[it].launchSuccess),
                                                        style = textStyleBoolColorPresentation(launchesPresentation[it].launchSuccess))
                                                }
                                                Row {
                                                    Text(text = "${stringResource(Res.string.launch_year)}${launchesPresentation[it].launchDateUTC}")
                                                }
                                                Row {
                                                    Text(text = "${stringResource(Res.string.launch_details)}${launchesPresentation[it].details}")
                                                }
                                                Row(
                                                    horizontalArrangement = Arrangement.End,
                                                    modifier = Modifier.fillMaxWidth()) {
                                                    var openUri by remember { mutableStateOf(false) }

                                                    if (openUri) {

                                                        listOf(
                                                            launchesPresentation[it].articleUrl,
                                                            launchesPresentation[it].patchUrlLarge,
                                                            launchesPresentation[it].patchUrlSmall,
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


