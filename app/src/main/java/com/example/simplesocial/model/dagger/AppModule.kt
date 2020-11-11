package com.example.simplesocial.model.dagger

import android.app.Application
import com.example.simplesocial.model.repo.SimpleSocialDao
import com.example.simplesocial.model.repo.SimpleSocialRepository
import com.example.simplesocial.model.repo.SimpleSocialUserDatabase
import com.example.simplesocial.util.ApplicationSingleton
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: Application) {
    private var database: SimpleSocialUserDatabase = SimpleSocialUserDatabase.getDatabase(app.applicationContext)
    @Provides
    fun provideApplication() = app

    @Singleton
    @Provides
    fun provideSimpleSocialUserDatabase() : SimpleSocialUserDatabase = database

    @Provides
    fun provideRepository(simpleSocialDao: SimpleSocialDao) : SimpleSocialRepository{
        return SimpleSocialRepository(simpleSocialDao)
    }

    @Provides
    fun provideSimpleSocialDao() : SimpleSocialDao = database.simpleSocialDao()
}