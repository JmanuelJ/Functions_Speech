package com.example.functionsspeech.domain.model

sealed class Response<out T> {
    data object Loading: Response<Nothing>()
    data class Success<T>(val data: T): Response<T>()
    data class Error(val errorMessage: String): Response<Nothing>()
}