package com.brenobatista.desafiozup.Views

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.brenobatista.desafiozup.Models.AppUser
import com.brenobatista.desafiozup.Models.Status
import com.brenobatista.desafiozup.R
import com.brenobatista.desafiozup.Services.UsersResult
import com.brenobatista.desafiozup.Services.createService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(findViewById(R.id.toolbar))

        var service = createService()
        service.searchUsers().enqueue(object : Callback<UsersResult> {

            override fun onFailure(call: Call<UsersResult>, t: Throwable) {
                // Tratar exceções
                Log.wtf("GET_DATA_ERROR","Erro ao obter dados do serviço", t)
            }

            override fun onResponse(call: Call<UsersResult>, response: Response<UsersResult>) {
                val data = response.body()
                val repos = data?.users
            }
        })
    }
}