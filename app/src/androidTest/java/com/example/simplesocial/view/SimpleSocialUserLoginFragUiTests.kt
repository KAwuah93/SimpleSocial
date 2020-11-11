package com.example.simplesocial.view

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.simplesocial.R
import kotlinx.android.synthetic.main.fragment_login.view.*
import org.hamcrest.core.IsNot.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class SimpleSocialUserLoginFragUiTests {
    private lateinit var wrong_login : String
    private lateinit var test_login : String

    @Before
    fun tStart() {
        wrong_login = "dummy"
        test_login = "testuser"
    }

    @get:Rule
    var activityRule : ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun loginFragment_wrongLoginInfo_sameActivity() {
        onView(withId(R.id.loginFrag_et_username))
            .perform(typeText(wrong_login), closeSoftKeyboard())
        onView(withId(R.id.loginFrag_et_password))
            .perform(typeText(wrong_login), closeSoftKeyboard())
        onView(withId(R.id.LoginFrag_btn_Login)).perform(click())

        // check that warning came up
        onView(withId(R.id.loginFrag_tv_hint))
            .check(matches(withText("Please check Login info!")))
    }

    @Test
    fun loginFragment_lockedLoginOnlyUsername_sameActivity() {
        onView(withId(R.id.loginFrag_et_username))
            .perform(typeText(wrong_login), closeSoftKeyboard())

        onView(withId(R.id.LoginFrag_btn_Login))
            .check(matches(not(isEnabled())))

    }

    @Test
    fun loginFragment_lockedLoginOnlyPassword_sameActivity() {
        onView(withId(R.id.loginFrag_et_password))
            .perform(typeText(wrong_login), closeSoftKeyboard())

        onView(withId(R.id.LoginFrag_btn_Login))
            .check(matches(not(isEnabled())))
    }

    @Test
    fun loginFragment_passwordLockEnabled_sameActivity() {
        onView(withId(R.id.loginFrag_et_password))
            .perform(typeText(wrong_login), closeSoftKeyboard())
        onView(withId(R.id.loginFrag_et_username))
            .perform(typeText(wrong_login), closeSoftKeyboard())

        onView(withId(R.id.LoginFrag_btn_Login))
            .check(matches(isEnabled()))
    }
}