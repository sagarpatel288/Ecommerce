package com.example.android.ecommerce.base

import android.app.Application
import com.example.android.ecommerce.di.dbmodules.dbModule
import com.example.android.ecommerce.di.viewmodules.viewModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(dbModule, viewModules))
        }
    }
}