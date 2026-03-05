package com.drobie.client.di

import com.drobie.client.ui.SplashViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::SplashViewModel)
}
