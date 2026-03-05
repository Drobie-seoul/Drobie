package com.drobie.client

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.drobie.client.di.appModule
import com.drobie.client.ui.SplashScreen
import com.drobie.client.ui.theme.DrobieTheme
import org.koin.compose.KoinApplication

@Composable
fun App() {
    KoinApplication(application = { modules(appModule) }) {
        DrobieTheme {
            var showSplash by remember { mutableStateOf(true) }
            if (showSplash) {
                SplashScreen(onFinished = { showSplash = false })
            } else {
                Box(modifier = Modifier.safeContentPadding()) {
                    Text("메인 화면")
                }
            }
        }
    }
}
