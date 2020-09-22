package com.brenobatista.desafiozup.Services

import com.brenobatista.desafiozup.Models.ServicesResult
import com.brenobatista.desafiozup.Models.UsersResult
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface IWebService {
    @GET("/zupbank/api/servicetypes")
    fun getServices(
    ): Call<ServicesResult>

    @GET("/zupbank/api/appusers")
    fun getUsers(
    ): Call<UsersResult>
}

fun createService(): IWebService {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://bankserviceitem.free.beeceptor.com")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    return retrofit.create(IWebService::class.java)
}