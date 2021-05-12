package com.lucascabral.nasa_spacedaily

import android.app.Application
import com.lucascabral.nasa_spacedaily.di.appModule
import com.lucascabral.nasa_spacedaily.di.networkModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SpaceApp : Application() {
    val defaultCurrentActivityListener: DefaultCurrentActivityListener by inject()
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@SpaceApp)
            modules(listOf(networkModule, appModule))
        }
        registerActivityLifecycleCallbacks(defaultCurrentActivityListener)
    }
}