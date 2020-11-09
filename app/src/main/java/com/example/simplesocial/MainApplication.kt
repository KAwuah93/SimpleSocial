package com.example.simplesocial

import android.app.Application
import com.example.simplesocial.model.dagger.AppComponent

class MainApplication : Application() {
    private lateinit var daggerAppComponent : AppComponent

    override fun onCreate() {
        super.onCreate()

        daggerAppComponent = AppComponent.create()
    }
}