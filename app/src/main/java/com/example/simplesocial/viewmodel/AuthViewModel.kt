package com.example.simplesocial.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplesocial.model.dagger.MainAppComponent
import com.example.simplesocial.model.data.SimpleSocialUser
import com.example.simplesocial.model.repo.SimpleSocialRepository
import com.example.simplesocial.util.ApplicationSingleton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class AuthViewModel() : ViewModel(){

    @Inject lateinit var simpleSocialRepository: SimpleSocialRepository
    var injector : MainAppComponent

    init {
        injector = ApplicationSingleton.applicationComponent
        injector.inject(this)
    }
    fun checkUser(user: String): Boolean {
        //do the search to make sure if username exists
        var exist = 0
        CoroutineScope(IO).launch{
                exist = simpleSocialRepository.userCountCheck(user)
            //delay(1000)
        }

        if (exist == 0) {
            return true
        }
        return false
    }

    suspend fun verifyUser(u : String, p : String) : SimpleSocialUser{
        // check if the user name and password matches in the database
        val user = simpleSocialRepository.loginAuth(u,p)
        return user
    }

    suspend fun registerUser(user : SimpleSocialUser){
        simpleSocialRepository.registerUser(user)
    }

}