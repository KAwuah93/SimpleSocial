package com.example.simplesocial.model.repo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.simplesocial.model.data.SimpleSocialUser

@Dao
interface SimpleSocialDao {
    // create to do the database things for the simple social interaction with the database
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(user: SimpleSocialUser)

    //update user
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUser(user: SimpleSocialUser)

    // fetch username and password Note: Could use 'livedata' if you write over the data through some other service
    @Query("SELECT * FROM simpleSocialUser_table where username = :selectedUsername AND password = :selectedPassword")
    fun fetchUser(selectedUsername : String, selectedPassword : String) : SimpleSocialUser

    //get the user
    @Query("SELECT * FROM simpleSocialUser_table where username LIKE :passedUsername")
    fun getUser(passedUsername : String): SimpleSocialUser
}