package com.brenobatista.desafiozup.Views

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.brenobatista.desafiozup.R
import kotlinx.android.synthetic.main.activity_cadastro.*


class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        findViewById<Button>(R.id.buttonInsertNewUser).setOnClickListener {

            var newUserName = editTextUsername.text.toString()
            var newPassword = editTextPassword.text.toString()

            val returnIntent = Intent()
            returnIntent.putExtra("newUserName", newUserName)
            returnIntent.putExtra("newPassword", newPassword)
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }

    }


}