package com.example.simplesocial.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.example.simplesocial.R
import com.example.simplesocial.databinding.ActivityMainBinding
import com.example.simplesocial.model.data.SimpleSocialUser
import com.example.simplesocial.view.fragments.LoginFragment
import com.example.simplesocial.viewmodel.ProfileViewModel
import dagger.android.AndroidInjection

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        //AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

//        //Doing the ViewModel Thing
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        var binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
//        // Needed for the changes we were making
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        // messing with the fragments
        // todo create branching logic to move ahead to the profile if you are 'signed in'
        val firstFragment = LoginFragment()
        firstFragment.arguments = intent.extras
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.main_fl_screen,firstFragment)
        transaction.commit()

    }
}