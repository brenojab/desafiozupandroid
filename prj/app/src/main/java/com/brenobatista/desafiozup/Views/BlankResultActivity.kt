package com.brenobatista.desafiozup.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.brenobatista.desafiozup.R

class BlankResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blank_result)
    }

    override fun onResume() {
        super.onResume()

        var result = intent.getStringExtra("CALLED_INTENT_TEXT")
        Toast.makeText(this, result, Toast.LENGTH_LONG).show()
    }
}