package com.mhmdbh.portfolio

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import kotlinx.browser.window


@OptIn(ExperimentalComposeUiApi::class)
fun main() {

    ComposeViewport(document.body!!) {

        App(
            screenSize = rememberWindowSize()
        ){

            when (it) {
                is AppEvent.NavToByLink -> {
                    window.open(
                        url = it.link,
                        target = "_blank"
                    )
                }
                is AppEvent.SentMail -> {
                    openMailClient(
                        email = it.email,
                        subject = "Book A Consultation",
                        body = "Dear Mr.Mohammad Husain"
                    )
                }
            }
        }
    }
}

fun openMailClient(email: String, subject: String = "", body: String = "") {
    val mailtoUrl = "mailto:$email?subject=${encodeURIComponent(subject)}&body=${encodeURIComponent(body)}"
    window.open(mailtoUrl)
}

fun encodeURIComponent(value: String): String = js("encodeURIComponent(value)") //as String