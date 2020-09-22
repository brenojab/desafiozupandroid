package com.brenobatista.desafiozup.Models

import com.google.gson.annotations.SerializedName

data class ServiceData(
    @SerializedName("serviceName")
    val serviceName: String
)