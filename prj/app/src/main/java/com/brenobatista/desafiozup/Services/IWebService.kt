package com.brenobatista.desafiozup.Services

import com.brenobatista.desafiozup.Models.AppUser
import com.brenobatista.desafiozup.Models.Status
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

fun createService(): IWebService {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://bankserviceitem.free.beeceptor.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(IWebService::class.java)
}

interface IWebService {
    @GET("/zupbank/api/servicetypes")
    fun searchServices(
    ): Call<ServicesResult>

    @GET("/zupbank/api/appusers")
    fun searchUsers(
    ): Call<UsersResult>

    @GET("/zupbank/api/status")
    fun status(
    ): Call<StatusResult>
}
