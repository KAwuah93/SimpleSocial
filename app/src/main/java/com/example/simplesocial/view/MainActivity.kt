package com.example.simplesocial.view

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.simplesocial.R
import com.example.simplesocial.databinding.ActivityMainBinding
import com.example.simplesocial.view.fragments.LoginFragment
import com.example.simplesocial.viewmodel.ProfileViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        var binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        // messing with the fragments
        // todo create branching logic to move ahead to the profile if you are 'signed in'
        val firstFragment = LoginFragment()
        firstFragment.arguments = intent.extras
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.main_fl_screen,firstFragment)
        transaction.commit()

        val sharedpref = this.getSharedPreferences("pref", Context.MODE_PRIVATE)
        // writing to shared pref
        val cachedUser : String? = sharedpref.getString("username","DEFAULT")
        if (cachedUser.equals("DEFAULT")){
            // move forward to the
        }
    }
}