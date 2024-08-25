package com.mhmdbh.portfolio.theme

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mhmdbh.portfolio.AppEvent
import com.mhmdbh.portfolio.DpSize
import com.mhmdbh.portfolio.OnlineAccountElement
import com.mhmdbh.portfolio.OnlineAccountModel
import com.mhmdbh.portfolio.OnlineAccountType
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.compose_multiplatform
import portfolio.composeapp.generated.resources.img_galaxy
import portfolio.composeapp.generated.resources.img_space_and_stars

@Composable
fun PortfolioScreen(
    modifier: Modifier = Modifier,
    screenSize: DpSize,
    onEvent: (AppEvent) -> Unit
) {


    val galaxyOffsetY: Dp by remember(
        screenSize.width
    ){

        println("App: screenSize.width=${screenSize.width}}")
        println("App: screenSize.height=${screenSize.height}}")

        mutableStateOf(
            when {
                screenSize.width < 600.dp -> 60.dp
                screenSize.width < 1200.dp -> 100.dp
                else -> 160.dp
            }.apply {
                println("App: returned galaxyOffsetY Dp=${this}")
            }
        )
    }

    val isScreenTesting by remember { mutableStateOf(false) }

    var showContent by remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()

    val defaultEnterTransition by remember {
        mutableStateOf(
            fadeIn(
                animationSpec = tween(
                    durationMillis = 5000
                )
            ) + expandIn(
                /*animationSpec = spring(
                    stiffness = Spring.StiffnessVeryLow,
                    visibilityThreshold = IntSize.VisibilityThreshold
                ),*/
                expandFrom = Alignment.TopEnd
            )
        )
    }

    val onlineAccountList by remember { mutableStateOf(OnlineAccountModel.default) }

    LaunchedEffect(Unit) {

        coroutineScope.launch {
            delay(200L)
            showContent = true
        }
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {

        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(Res.drawable.img_space_and_stars),
            contentScale = ContentScale.Crop,
            contentDescription = ""
        )

        AnimatedVisibility(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = galaxyOffsetY),
            visible = showContent,
            enter = defaultEnterTransition,

            ) {

            Image(
                modifier = Modifier.fillMaxWidth(0.6f)
                    .align(Alignment.BottomCenter)
                //.aspectRatio(16f / 9f) // Maintains 16:9 aspect ratio

                /*.padding(top = 100.dp)*/,
                painter = painterResource(Res.drawable.img_galaxy),
                contentScale = ContentScale.FillWidth,
                contentDescription = ""
            )
        }

        Box(
            modifier = Modifier.fillMaxSize()
                .padding(20.dp)
        ) {

            //Center Content
            AnimatedVisibility(
                modifier = Modifier.align(Alignment.Center),
                visible = showContent,
                enter = defaultEnterTransition
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 40.dp)
                    /*.align(Alignment.Center)*/,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    Text(
                        modifier = Modifier.padding(top = 20.dp),
                        text = "Existing Updates on the way".uppercase(),
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.tertiary,
                        fontWeight = FontWeight.Normal
                    )

                    Text(
                        modifier = Modifier.padding(top = 12.dp),
                        text = "Stay Tuned".uppercase(),
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.tertiary, //AEAEAE
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        modifier = Modifier.padding(top = 140.dp),
                        text = "Mohammad Husain".uppercase(),
                        style = MaterialTheme.typography.displayLarge,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = Modifier.padding(top = 20.dp),
                            text = "Mobile App Developer",
                            style = MaterialTheme.typography.headlineMedium,
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            fontWeight = FontWeight.Light
                        )

                        Card(
                            modifier = Modifier
                                .fillMaxWidth(.05f)
                                .height(10.dp)
                                .padding(top = 8.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White
                            ),
                        ) {}
                    }
                }
            }

            //Social Accounts Section
            AnimatedVisibility(
                modifier = Modifier.align(Alignment.BottomStart),
                visible = showContent,
                enter = defaultEnterTransition
            ) {

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(32.dp)
                ){
                    items(onlineAccountList){ onlineAccountModel ->

                        OnlineAccountElement(
                            title = onlineAccountModel.title,
                            type = onlineAccountModel.type,
                            onClick = { onlineAccountType ->
                                when (onlineAccountType) {
                                    is OnlineAccountType.Link -> {
                                        onEvent(
                                            AppEvent.NavToByLink(
                                                onlineAccountType.link
                                            )
                                        )
                                    }
                                    is OnlineAccountType.Mail -> {
                                        onEvent(
                                            AppEvent.SentMail(
                                                onlineAccountType.email
                                            )
                                        )
                                    }
                                }
                            }
                        )
                    }
                }
            }

            //App Icon - LOGO
            AnimatedVisibility(
                //modifier = Modifier.align(Alignment.TopStart),
                visible = showContent,
                enter = defaultEnterTransition
            ) {
                Image(
                    modifier = Modifier
                        .size(60.dp)
                        .align(Alignment.TopStart),
                    painter = painterResource(Res.drawable.compose_multiplatform),
                    contentDescription = ""
                )
            }

            if(isScreenTesting)
                Text(
                    text = "OffsetY= ${galaxyOffsetY.toString()}",
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.secondary
                )
        }
    }

}