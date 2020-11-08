package com.example.simplesocial.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simplesocial.model.data.SimpleSocialUser

class ProfileViewModel(): ViewModel() {
    // This is where the User data used across the application would be stored
    var user = MutableLiveData<SimpleSocialUser>()

    // using this to sync the data created
    fun select(selectedUser : SimpleSocialUser){
        user.value = selectedUser
    }

    fun updateUser(user: String){
        // take the username of the current user and do a query + overwrite with Corutines
    }
}