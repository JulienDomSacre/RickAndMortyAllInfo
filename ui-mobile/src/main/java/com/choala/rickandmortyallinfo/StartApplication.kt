package com.choala.rickandmortyallinfo

import android.app.Application
import com.choala.data.di.dataModule
import com.choala.domain.di.domainModule
import com.choala.network.di.networkModule
import com.choala.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class StartApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@StartApplication)
            modules(
                presentationModule,
                domainModule,
                dataModule,
                networkModule
            )
        }
    }
}