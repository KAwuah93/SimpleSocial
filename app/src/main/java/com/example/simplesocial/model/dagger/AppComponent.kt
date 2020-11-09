package com.example.simplesocial.model.dagger

import com.example.simplesocial.viewmodel.AuthViewModel
import dagger.Component
import dagger.Module
import javax.inject.Inject

@Component (modules = [AppModule::class])
interface AppComponent {

    fun inject(viewModel : AuthViewModel)
}