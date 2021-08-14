package com.example.testplayground.useCases

const val NETWORK_CONNECTION_ERROR = "Нет сетевого подключения"

sealed class Failure(val errorMessage: String? = null) {

    object NetworkConnectionError : Failure(NETWORK_CONNECTION_ERROR)
}