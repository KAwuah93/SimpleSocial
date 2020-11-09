package com.example.simplesocial.model.repo

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

public abstract class SimpleSocialUserDatabase : RoomDatabase() {
    abstract fun simpleSocialDao() : SimpleSocialDao

    companion object{
        @Volatile
        private var INSTANCE: SimpleSocialUserDatabase? = null
        fun getDatabase(context: Context) : SimpleSocialUserDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SimpleSocialUserDatabase::class.java,
                    "simpleSocial_Database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}