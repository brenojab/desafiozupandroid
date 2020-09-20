package com.brenobatista.desafiozup.Services

import com.google.gson.GsonBuilder
import com.squareup.moshi.Moshi
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

fun createService(): IWebService {
    val gson = GsonBuilder()
        .setLenient()
        .create()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://bankserviceitem.free.beeceptor.com")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    return retrofit.create(IWebService::class.java)
}

interface IWebService {
    @GET("/zupbank/api/servicetypes")
    fun searchServices(
    ): Call<SearchResult>
}
