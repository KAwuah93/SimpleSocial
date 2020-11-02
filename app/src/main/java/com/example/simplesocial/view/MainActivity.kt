package com.example.simplesocial.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.simplesocial.R
import com.example.simplesocial.databinding.ActivityMainBinding
import com.example.simplesocial.viewmodel.ProfileViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        //Doing the ViewModel Thing
        var viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        var binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

    }

    fun onClick(v : View){
        val intent = Intent(this,RegisterActivity::class.java)
        startActivity(intent)
    }
}