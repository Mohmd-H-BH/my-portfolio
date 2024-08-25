package com.mhmdbh.portfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App(DpSize(1024.dp,740.dp)) {}
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App(DpSize(1024.dp,740.dp)) {}
}