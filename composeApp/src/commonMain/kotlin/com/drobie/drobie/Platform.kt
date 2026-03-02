package com.drobie.drobie

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform