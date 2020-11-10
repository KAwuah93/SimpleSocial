package com.example.simplesocial

import android.app.Application
import com.example.simplesocial.model.dagger.MainAppComponent

class MainApplication : Application() {


    private lateinit var mainAppComponent: MainAppComponent

    override fun onCreate() {
        super.onCreate()
        //mainAppComponent =
    }
}