package com.example.simplesocial.model.dagger

import com.example.simplesocial.view.HomeScreenActivity
import com.example.simplesocial.view.MainActivity
import com.example.simplesocial.viewmodel.AuthViewModel
import dagger.Component

@Component(
    modules = [
        AppModule::class,
        ViewModelFactoryModule::class
])
interface MainAppComponent {
    fun inject(viewModel : AuthViewModel)
    fun inject(activity: MainActivity)
    fun inject(activity: HomeScreenActivity)
}