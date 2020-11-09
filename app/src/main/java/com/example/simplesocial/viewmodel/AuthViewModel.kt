package com.example.simplesocial.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.simplesocial.model.dagger.AppModule
import com.example.simplesocial.model.data.SimpleSocialUser
import com.example.simplesocial.model.repo.SimpleSocialRepository
import dagger.android.AndroidInjection
import javax.inject.Inject

class AuthViewModel() : ViewModel(){

    // Centralize access to the data between the classes.
    // Todo auto inject Database
    @Inject lateinit var simpleSocialRepository: SimpleSocialRepository

    fun checkUser(user: String): Boolean {
        //do the search to make sure if username exists
        return false
    }

    fun verifyUser(u : String, p : String){
        // check if the user name and password matches in the database
    }

    fun registerUser(user : SimpleSocialUser){
        // take the returned User and Insert it into the database
        simpleSocialRepository.registerUser(user)

        // Also save the user to SharedPref.

        // Send the User to the HomeScreen Activity after you are done
    }
}