package com.brenobatista.desafiozup.Models

import com.google.gson.annotations.SerializedName

data class AppUser(
    @SerializedName("username")
    var username: String,
    @SerializedName("password")
    var password: String
)