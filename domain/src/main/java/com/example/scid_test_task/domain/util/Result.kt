package com.example.scid_test_task.domain.util

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Throwable, val message: String? = null) : Result<Nothing>() {
        val errorMessage: String
            get() = message ?: exception.message ?: "Неизвестная ошибка"
    }
    object Loading : Result<Nothing>()
}

