package com.example.challengekonfio.utils

data class BaseError(
    var cause: String = "Operación no realizada",
    var code: Int = -1,
    var exception: Exception? = null
)
