package com.example.simplesocial.model.repo

import com.example.simplesocial.model.data.SimpleSocialUser

class SimpleSocialRepository (private val simpleSocialDao: SimpleSocialDao){

    // log in auth
    suspend fun loginAuth(selectedUserName : String, selectedPassword : String) : SimpleSocialUser {
        return simpleSocialDao.fetchUser(selectedUserName, selectedPassword)
    }

    // registration
    suspend fun registerUser(selectedUser : SimpleSocialUser){
        simpleSocialDao.insertUser(selectedUser)
    }

    // check to see if there is another record involved
    suspend fun userCountCheck(searchUserName : String): Int{
        return simpleSocialDao.getUserCount(searchUserName)
    }

    //update user
    suspend fun updateUser(cachedUsername: SimpleSocialUser){
        simpleSocialDao.updateUser(cachedUsername)
    }
}