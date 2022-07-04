package com.example.challengekonfio.utils

sealed class DataState<out T> {
    object Loading: DataState<Nothing>()
    data class Success<out T: Any>(val data: T): DataState<T>()
    data class Error(val error: BaseError) : DataState<Nothing>()
}
