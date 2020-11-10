package com.example.simplesocial.model.dagger

import com.example.simplesocial.viewmodel.AuthViewModel
import dagger.Component

@Component(modules = [AppModule::class])
interface MainAppComponent {
    fun inject(viewModel : AuthViewModel)
}