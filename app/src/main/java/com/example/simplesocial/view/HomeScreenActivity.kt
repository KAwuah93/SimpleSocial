package com.example.simplesocial.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.simplesocial.R
import com.example.simplesocial.databinding.ActivityHomeScreenBinding

import com.example.simplesocial.model.data.SimpleSocialUser
import com.example.simplesocial.viewmodel.ProfileViewModel

class HomeScreenActivity : AppCompatActivity() {
    private lateinit var viewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        //Create the viewModel and get the Data class from the Bundle
        //Doing the ViewModel Thing
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        var binding = DataBindingUtil.setContentView<ActivityHomeScreenBinding>(this,R.layout.activity_home_screen)
        // Needed for the changes we were making
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        //pulling the user from the bundle
        //todo make sure that you have some level of
        var bundle : Bundle? = intent.extras
        viewModel.loggedUser = bundle?.get("user") as SimpleSocialUser

        var t = Toast.makeText(this,viewModel.loggedUser.username,Toast.LENGTH_LONG)
        t.show()
    }
}