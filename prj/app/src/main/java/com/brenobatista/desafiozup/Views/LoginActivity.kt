package com.brenobatista.desafiozup.Views

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.brenobatista.desafiozup.Models.AppUser
import com.brenobatista.desafiozup.R
import com.brenobatista.desafiozup.ViewModels.LoginViewModel
import kotlinx.android.synthetic.main.content_login.*


class LoginActivity : AppCompatActivity() {

    companion object {
        private val vm = LoginViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(findViewById(R.id.toolbar))

        imageViewLogo.setImageResource(R.mipmap.logo)

        // Criação dos serviços de consumo de APIs
        vm.initServices()

        findViewById<Button>(R.id.buttonLogin).setOnClickListener {

            val username = editTextUsuario?.text.toString()
            val password = editTextPassword?.text.toString()

            if (vm.canLogin(username, password)) {
                val intent = Intent(this, MainListViewActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Login inválido!", Toast.LENGTH_LONG).show()
            }
        }

        findViewById<Button>(R.id.buttonCadastro).setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)

            startActivityForResult(intent, 1);
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Adiciona novo usuário, retornado do cadastro
        val newUserName = intent.getStringExtra("newUserName").toString()
        val newPassword = intent.getStringExtra("newPassword").toString()

        if (!newUserName.isNullOrEmpty() && !newPassword.isNullOrEmpty()) {
            val newUser = AppUser(newUserName, newPassword)
            vm.appUsers?.add(newUser)
        }
    }
}
