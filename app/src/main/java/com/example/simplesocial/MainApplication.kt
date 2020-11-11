package com.example.simplesocial

import android.app.Application
import com.example.simplesocial.model.dagger.AppModule
import com.example.simplesocial.model.dagger.DaggerMainAppComponent
import com.example.simplesocial.model.dagger.MainAppComponent
import com.example.simplesocial.util.ApplicationSingleton

class MainApplication : Application() {
    lateinit var mainAppComponent: MainAppComponent

    override fun onCreate() {
        super.onCreate()

        mainAppComponent = DaggerMainAppComponent.builder()
            .appModule(AppModule(this))
            .build()

        ApplicationSingleton.applicationComponent = mainAppComponent
    }
}