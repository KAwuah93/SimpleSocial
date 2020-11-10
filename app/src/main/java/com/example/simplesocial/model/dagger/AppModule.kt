package com.example.simplesocial.model.dagger

import android.app.Application
import com.example.simplesocial.model.repo.SimpleSocialRepository
import com.example.simplesocial.model.repo.SimpleSocialUserDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: Application) {

    @Provides
    fun provideApplication() = app

    @Singleton
    @Provides
    fun provideSimpleSocialUserDatabase(context: Application) : SimpleSocialUserDatabase{
        return SimpleSocialUserDatabase.getDatabase(context)
    }

    @Provides
    fun provideRepository(){
        return SimpleSocialRepository()
    }
}