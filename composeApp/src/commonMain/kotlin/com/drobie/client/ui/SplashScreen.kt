package com.drobie.client.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.drobie.client.ui.theme.DrobieTheme
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SplashScreen(
    onFinished: () -> Unit,
    viewModel: SplashViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    if (uiState.isFinished) {
        onFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DrobieTheme.colors.background),
        contentAlignment = Alignment.Center
    ) {
        Text("DROBIE", color = DrobieTheme.colors.textPrimary)
    }
}
