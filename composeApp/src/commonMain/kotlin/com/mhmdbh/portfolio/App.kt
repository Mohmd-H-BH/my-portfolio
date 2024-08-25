package com.mhmdbh.portfolio

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mhmdbh.portfolio.theme.AppTheme
import com.mhmdbh.portfolio.theme.PortfolioScreen
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.compose_multiplatform


@Composable
@Preview
fun App(
    screenSize: DpSize,
    onEvent: (AppEvent) -> Unit
) {

    AppTheme {

        //ComposeScreen()
        PortfolioScreen(
            screenSize = screenSize,
            onEvent = onEvent,
        )
    }
}



@Composable
fun ComposeScreen(modifier: Modifier = Modifier) {
    var showContent by remember { mutableStateOf(false) }
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
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

/*
Row(
modifier = Modifier
.fillMaxWidth()
.align(Alignment.BottomStart)
.padding(start = 0.dp */
/*bottom = 20.dp*//*
),
horizontalArrangement = Arrangement.spacedBy(40.dp)
) {

    //EMAIL
    Row(
        modifier = Modifier.padding(start = 0.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Text(
            modifier = Modifier,
            text = "Email:",
            //style = MaterialTheme3.typography.body1,
            color = MaterialTheme3.colorScheme.tertiary,
            fontWeight = FontWeight.Normal
        )

        Text(
            modifier = Modifier
                .clickable {

                    onEvent(
                        AppEvent.SentMail(
                            "mohmd.h.bh@gmail.com"
                        )
                    )
                },
            text = "mohmd.h.bh@gmail.com",
            //style = MaterialTheme3.typography.button,
            color = Color.White,
            fontWeight = FontWeight.Normal
        )

        Icon(
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    onEvent(
                        AppEvent.SentMail(
                            "mohmd.h.bh@gmail.com"
                        )
                    )
                },
            painter = painterResource(Res.drawable.img_maximize_64x),
            contentDescription = ""
        )
    }

    //LinkedIn
    Row(
        modifier = Modifier.padding(start = 0.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Text(
            modifier = Modifier,
            text = "LinkedIn:",
            //style = MaterialTheme3.typography.body1,
            color = MaterialTheme3.colorScheme.tertiary,
            fontWeight = FontWeight.Normal
        )

        Text(
            modifier = Modifier
                .clickable {
                    onEvent(
                        AppEvent.NavToByLink(
                            "https://linkedin.com/in/mohmd-h-bh"
                        )
                    )
                },
            text = "linkedin.com/in/mohmd-h-bh",
            //style = MaterialTheme3.typography.button,
            color = Color.White,
            fontWeight = FontWeight.Normal
        )

        Icon(
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    onEvent(
                        AppEvent.SentMail(
                            "mohmd.h.bh@gmail.com"
                        )
                    )
                },
            painter = painterResource(Res.drawable.img_maximize_64x),
            tint = MaterialTheme3.colorScheme.secondary,
            contentDescription = ""
        )
    }
}*/
