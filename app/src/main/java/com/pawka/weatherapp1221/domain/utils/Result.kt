package com.pawka.weatherapp1221.domain.utils

sealed class Result<out T : Any> {
    class Success<out T : Any>(val data: T) : Result<T>()
    class Failure(val exception: Exception) : Result<Nothing>()
}
