package com.pawka.weatherapp1221.domain.usecases

import com.pawka.weatherapp1221.domain.repos.WeatherRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetWeatherUseCase() : KoinComponent {
    private val weatherRepository: WeatherRepository by inject()
    operator fun invoke() = weatherRepository.getWeather()
}