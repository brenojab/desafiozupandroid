package com.brenobatista.desafiozup.ViewModels

import android.util.Log
import com.brenobatista.desafiozup.Models.UsersResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : BaseViewModel() {

    fun initServices() {
        return service.getUsers().enqueue(object : Callback<UsersResult> {

            override fun onFailure(call: Call<UsersResult>, t: Throwable) {
                // Tratar exceções
                Log.wtf("GET_DATA_ERROR", "Erro ao obter dados do serviço", t)
            }

            override fun onResponse(call: Call<UsersResult>, response: Response<UsersResult>) {
                val data = response.body()
                val repos = data?.users
            }
        })
    }
}