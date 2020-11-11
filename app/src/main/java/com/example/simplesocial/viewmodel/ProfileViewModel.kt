package com.example.simplesocial.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simplesocial.model.dagger.MainAppComponent
import com.example.simplesocial.model.data.SimpleSocialUser
import com.example.simplesocial.model.repo.SimpleSocialRepository
import com.example.simplesocial.util.ApplicationSingleton
import javax.inject.Inject

class ProfileViewModel(): ViewModel() {
    // This is where the User data used across the application would be stored
    var user = MutableLiveData<SimpleSocialUser>()

    @Inject
    lateinit var simpleSocialRepository: SimpleSocialRepository

    @Inject
    lateinit var mainAppComponent: MainAppComponent

    init {
        mainAppComponent.inject(this)
    }

    // using this to sync the data created
    fun select(selectedUser : SimpleSocialUser){
        user.value = selectedUser
    }

    suspend fun updateUser(){
        simpleSocialRepository.updateUser(user.value!!)
    }
}