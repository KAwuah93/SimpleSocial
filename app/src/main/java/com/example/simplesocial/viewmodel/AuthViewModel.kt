package com.example.simplesocial.viewmodel

import androidx.lifecycle.ViewModel
import com.example.simplesocial.model.data.SimpleSocialUser

class AuthViewModel : ViewModel(){

    // Centralize access to the data between the classes.
    // Todo auto inject Database

    fun checkUser(user: String): Boolean {
        //do the search to make sure if username exists
        return false
    }

    fun verifyUser(u : String, p : String){
        // check if the user name and password matches in the database
    }

    fun registerUser(user : SimpleSocialUser){
        // take the returned User and Insert it into the database

        // Also save the user to SharedPref.

        // Send the User to the HomeScreen Activity after you are done
    }
}