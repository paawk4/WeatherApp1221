package com.pawka.weatherapp1221

import android.app.Application
import com.pawka.weatherapp1221.di.repositoriesModule
import com.pawka.weatherapp1221.di.useCasesModule
import com.pawka.weatherapp1221.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WeatherApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@WeatherApplication)
            modules(listOf(repositoriesModule, viewModelsModule, useCasesModule))
        }
    }
}