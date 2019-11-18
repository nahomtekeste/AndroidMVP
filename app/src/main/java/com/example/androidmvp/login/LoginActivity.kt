package com.example.androidmvp.login

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ProgressBar
import com.example.androidmvp.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var username :EditText
    private lateinit var password :EditText
    private lateinit var presenter : LoginActivity

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        progressBar = findViewById(R.layout.activity_login)
        username = findViewById(R.layout.activity_login)
        password = findViewById(R.layout.activity_login)

        // this button allow the user to be able  to get to the new activity
        btn_login.setOnClickListener {
            var intent = Intent (applicationContext , LoginActivity::class.java)
            startActivity(intent)
        }


    }
}
