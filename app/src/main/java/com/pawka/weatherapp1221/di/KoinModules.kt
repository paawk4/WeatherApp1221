package com.pawka.weatherapp1221.di

import com.pawka.weatherapp1221.data.repos.WeatherRepositoryImpl
import com.pawka.weatherapp1221.data.retrofit.RetrofitService
import com.pawka.weatherapp1221.domain.repos.WeatherRepository
import com.pawka.weatherapp1221.domain.usecases.GetWeatherUseCase
import com.pawka.weatherapp1221.presentation.viewmodels.MainWeatherScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoriesModule = module {
    single { RetrofitService() }
    single<WeatherRepository> { WeatherRepositoryImpl(get()) }
}

val viewModelsModule = module {
    viewModel { MainWeatherScreenViewModel(get()) }
}

val useCasesModule = module {
    single { GetWeatherUseCase() }
}