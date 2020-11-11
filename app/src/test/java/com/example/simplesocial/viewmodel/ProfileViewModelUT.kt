package com.example.simplesocial.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.simplesocial.model.dagger.MainAppComponent
import com.example.simplesocial.model.data.SimpleSocialUser
import com.example.simplesocial.model.repo.SimpleSocialRepository
import com.example.simplesocial.util.ApplicationSingleton
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ProfileViewModelUT {


    val testLine = "test"
    val testUser = "daMan2020"
    @Mock
    lateinit var simpleSocialRepository : SimpleSocialRepository

    @Mock
    lateinit var injector : MainAppComponent


    @InjectMocks
    var model = getDummyViewModel()


    @Test
    fun updateUser() = runBlocking{
        var user = generateDummyUser()
        var userWrapper = MutableLiveData<SimpleSocialUser>(user)
        model.user = userWrapper
        model.updateUser()

        verify(simpleSocialRepository).updateUser(model.user.value!!)
    }

    private fun generateDummyUser() : SimpleSocialUser{
        var simpleDummy = SimpleSocialUser()
        simpleDummy.username = testUser
        return simpleDummy
    }

    private fun getDummyViewModel() : ProfileViewModel{
        injector = Mockito.mock(MainAppComponent::class.java)
        ApplicationSingleton.applicationComponent = injector
        return ProfileViewModel()
    }


}