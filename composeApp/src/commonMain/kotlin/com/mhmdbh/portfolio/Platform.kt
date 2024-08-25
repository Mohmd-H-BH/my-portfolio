package com.mhmdbh.portfolio

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform