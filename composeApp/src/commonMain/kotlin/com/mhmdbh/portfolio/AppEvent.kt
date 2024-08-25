package com.mhmdbh.portfolio

sealed class AppEvent(){

    data class SentMail(val email: String): AppEvent()
    data class NavToByLink(val link: String): AppEvent()
}
