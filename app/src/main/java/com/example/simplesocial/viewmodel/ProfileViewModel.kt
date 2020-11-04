package com.example.simplesocial.viewmodel

import androidx.lifecycle.ViewModel
import com.example.simplesocial.model.data.SimpleSocialUser

class ProfileViewModel(): ViewModel() {
    var username : String = ""
    var password : String = ""

    var loggedUser : SimpleSocialUser = SimpleSocialUser()
    // Get the user
    fun verifyLogIn(){

    }

    fun getUser(){}

    fun registerUser(){}

}