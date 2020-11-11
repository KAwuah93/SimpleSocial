package com.example.simplesocial.viewmodel

import com.example.simplesocial.model.dagger.MainAppComponent
import com.example.simplesocial.model.data.SimpleSocialUser
import com.example.simplesocial.model.repo.SimpleSocialRepository
import com.example.simplesocial.util.ApplicationSingleton
import junit.framework.Assert.assertSame
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AuthViewModelUT() {

    val testLine = "test"
    val testUser = "daMan2020"
    @Mock
    lateinit var simpleSocialRepository : SimpleSocialRepository

    @Mock
    lateinit var injector : MainAppComponent

    @InjectMocks
    var model = getDummy()

    @Test
    fun checkUserDoesExit() = runBlocking{

        `when`(simpleSocialRepository.userCountCheck(testLine)).thenReturn(1)

        val testValue = model.checkUser(testLine)

        print(testValue)

        assert(testValue)
    }

    @Test
    fun verifyUser() = runBlocking{
        val x = "x"
        val y = "y"

        `when`(simpleSocialRepository.loginAuth(x,y)).thenReturn(dummyUser())

        val holder = model.verifyUser(x,y)

        //print(testValue)

        assertSame(holder.username,testUser)
    }

    @Test
    fun registerUser() = runBlocking{
        var x = "x"
        var y = "y"

        val dummyUser = dummyUser()

        val dataholder = model.registerUser(dummyUser)

        verify(simpleSocialRepository).registerUser(dummyUser)

    }

    private fun getDummy() : AuthViewModel{
        injector = mock(MainAppComponent::class.java)
        ApplicationSingleton.applicationComponent = injector
        return AuthViewModel()
    }

    private fun dummyUser() : SimpleSocialUser {
        val dummyUser = SimpleSocialUser()
        dummyUser.username = testUser
        return dummyUser
    }
}