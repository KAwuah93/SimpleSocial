package com.example.simplesocial.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.simplesocial.R
import com.example.simplesocial.databinding.ActivityHomeScreenBinding

import com.example.simplesocial.model.data.SimpleSocialUser
import com.example.simplesocial.view.fragments.LoginFragment
import com.example.simplesocial.view.fragments.ProfileFragment
import com.example.simplesocial.viewmodel.ProfileViewModel

class HomeScreenActivity : AppCompatActivity() {
    private lateinit var viewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Create the viewModel and get the Data class from the Bundle
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        var binding = DataBindingUtil.setContentView<ActivityHomeScreenBinding>(this,R.layout.activity_home_screen)
        // Needed for the changes we were making
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        
        var bundle : Bundle? = intent.extras
        viewModel.user.value = bundle?.get("user") as SimpleSocialUser
        bundle?.get("user")?.let {
            val firstFragment = ProfileFragment()
            //firstFragment.arguments = intent.extras
            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.Home_fv_screen, firstFragment)
            transaction.commit()

            val sharedpref = this.getSharedPreferences("pref", Context.MODE_PRIVATE)
            // writing to shared pref
            sharedpref.edit().putString("username",viewModel.user.value!!.username).apply()
            sharedpref.edit().putString("password",viewModel.user.value!!.password).apply()
        }
    }

}