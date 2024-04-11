import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cleanArchitecturePlusSOLID.layerPresentation.Presentation
import cleanArchitecturePlusSOLID.layerDomain.Interactor
import com.example.Launch
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import io.ktor.http.Url
import io.ktor.http.headers
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
fun App(interactor: Interactor,presentation:Presentation) {

    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }

        var temp by remember { mutableStateOf<List<Launch>>(listOf()) }

        LaunchedEffect(""){
            presentation.mutableRocketLaunches.collectLatest{
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
                        Card(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
                            Column {
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
                                Row {
                                    //ImageRequest()
//                                    val painter = rememberImagePainter("${temp[it].patchUrlSmall}")
//                                    Image(
//                                        painter = painter,
//                                        contentDescription = "image",
//                                    )
                                    //Text(text = "${temp[it].patchUrlSmall}")
                                    //AsyncImage("${temp[it].patchUrlSmall}", contentDescription = null)

//                                    val client = remember { HttpClient(){} }
//                                    LaunchedEffect(""){
//                                        runCatching {
//
//                                                val byteArray=client.get(Url("${temp[it].patchUrlSmall}"))
//
//                                                //val channel=byteArray.bodyAsChannel().copyAndClose()
//
//                                            val qq=byteArray.call.body<Any>()
//                                            qq.toString()
//
//
//                                            q.toString()
//
//                                            }
//                                        }

                                    KamelImage(
                                        resource = asyncPainterResource(Url("${temp[it].patchUrlSmall}").apply {
                                            headers {
                                                set("Access-Control-Allow-Origin", "https://normal-website.com")
                                            }
                                        }),
                                        contentDescription = null)

                                }
                                Row {
                                    TextField("${temp[it].patchUrlLarge}",{})
                                }
                                Row {
                                    Text(text = "${temp[it].articleUrl}")
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