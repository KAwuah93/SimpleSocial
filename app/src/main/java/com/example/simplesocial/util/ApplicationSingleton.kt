package com.example.simplesocial.util

import com.example.simplesocial.model.dagger.MainAppComponent

object ApplicationSingleton {
    lateinit var applicationComponent: MainAppComponent

    public fun provideSingleton() : MainAppComponent{
        return applicationComponent
    }
}