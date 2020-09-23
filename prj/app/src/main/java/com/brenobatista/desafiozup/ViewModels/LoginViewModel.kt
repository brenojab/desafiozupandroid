package com.brenobatista.desafiozup.ViewModels

import android.text.Editable
import android.util.Log
import com.brenobatista.desafiozup.Models.AppUser
import com.brenobatista.desafiozup.Models.UsersResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : BaseViewModel() {

    var appUsers: MutableList<AppUser>? = null

    fun initServices() {
        return service.getUsers().enqueue(object : Callback<UsersResult> {

            override fun onFailure(call: Call<UsersResult>, t: Throwable) {
                // Tratar exceções
                Log.wtf("GET_DATA_ERROR", "Erro ao obter dados do serviço", t)
            }

            override fun onResponse(call: Call<UsersResult>, response: Response<UsersResult>) {
                val data = response.body()
                var list = data?.users as MutableList<AppUser>
                appUsers = list
            }
        })
    }

    fun canLogin(username: String, password: String): Boolean {
        var lst = appUsers?.filter { it.username == username && it.password == password }
        return lst?.count()!! > 0
    }
}