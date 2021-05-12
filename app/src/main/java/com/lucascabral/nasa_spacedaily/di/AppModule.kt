package com.lucascabral.nasa_spacedaily.di

import com.lucascabral.nasa_spacedaily.ActivityRetriever
import com.lucascabral.nasa_spacedaily.DefaultCurrentActivityListener
import org.koin.dsl.module

val appModule = module {
    single { DefaultCurrentActivityListener() }
    single { ActivityRetriever(get()) }
}