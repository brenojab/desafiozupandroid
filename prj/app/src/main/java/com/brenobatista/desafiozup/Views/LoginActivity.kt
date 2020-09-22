package com.brenobatista.desafiozup.Views

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.brenobatista.desafiozup.R
import com.brenobatista.desafiozup.Models.UsersResult
import com.brenobatista.desafiozup.Services.createService
import com.brenobatista.desafiozup.ViewModels.CadastroViewModel
import com.brenobatista.desafiozup.ViewModels.LoginViewModel
import com.brenobatista.desafiozup.ViewModels.MainListViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    companion object{
        private val vm = LoginViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(findViewById(R.id.toolbar))

        // Criação dos serviços de consumo de APIs
        vm.initServices()


    }
}