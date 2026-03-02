package com.drobie.client

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform