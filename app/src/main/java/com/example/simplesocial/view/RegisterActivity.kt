package com.example.simplesocial.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.simplesocial.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun onClick(v : View){
        //create the object and then send it to the viewModel for the next activity.
        val intent = Intent(this, HomeScreenActivity::class.java)
        startActivity(intent)
    }
}