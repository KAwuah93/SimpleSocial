package com.example.simplesocial.model.repo

import com.example.simplesocial.model.data.SimpleSocialUser

class SimpleSocialRepository (private val simpleSocialDao: SimpleSocialDao){

    // log in auth
    fun loginAuth(selectedUserName : String, selectedPassword : String) : SimpleSocialUser {
        return simpleSocialDao.fetchUser(selectedUserName, selectedPassword)
    }

    // registration
    fun registerUser(selectedUser : SimpleSocialUser){
        simpleSocialDao.insertUser(selectedUser)
    }
}