package com.example.challengekonfio.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DogResponse(
    @SerializedName("dogName")
    @Expose
    var dogname: String = "",
    @SerializedName("description")
    @Expose
    var description: String = "",
    @SerializedName("age")
    @Expose
    var age: Int = -1,
    @SerializedName("image")
    @Expose
    var url: String = ""
    )
