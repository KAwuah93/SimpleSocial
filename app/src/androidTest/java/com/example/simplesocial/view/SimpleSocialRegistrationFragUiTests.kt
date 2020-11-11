package com.example.simplesocial.view

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.simplesocial.R
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class SimpleSocialRegistrationFragUiTests {
    private lateinit var filler_text : String
    private lateinit var userName: String
    private lateinit var password: String

    @Before
    fun tStart() {
        filler_text = "blah"
        userName = "testUser"
        password = "testpass"

        Espresso.onView(ViewMatchers.withId(R.id.LoginFrag_btn_Register)).perform(ViewActions.click())
    }

    @get:Rule
    var activityRule : ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun registerFragment_noDataEntered_sameActivity(){
        Espresso.onView(ViewMatchers.withId(R.id.register_btn_confirm)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.register_tv_hint))
            .check(ViewAssertions.matches(ViewMatchers.withText("Please fill out the form!")))
    }

    @Test
    fun registerFragment_passwordsDoNotMatch_sameActivity(){
        Espresso.onView(ViewMatchers.withId(R.id.register_et_fname))
            .perform(ViewActions.typeText(filler_text), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.register_et_lname))
            .perform(ViewActions.typeText(filler_text), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.register_et_username))
            .perform(ViewActions.typeText(userName), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.register_et_password))
            .perform(ViewActions.typeText(password), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.register_et_verify))
            .perform(ViewActions.typeText(filler_text), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.register_et_email))
            .perform(ViewActions.typeText(filler_text), ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.register_btn_confirm)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.register_tv_hint))
            .check(ViewAssertions.matches(ViewMatchers.withText("Verify Passwords are the same.")))
    }

    @Test
    fun registerFragment_registrationSuccess_sameActivity(){
        Espresso.onView(ViewMatchers.withId(R.id.register_et_fname))
            .perform(ViewActions.typeText(filler_text), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.register_et_lname))
            .perform(ViewActions.typeText(filler_text), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.register_et_username))
            .perform(ViewActions.typeText(userName), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.register_et_password))
            .perform(ViewActions.typeText(password), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.register_et_verify))
            .perform(ViewActions.typeText(password), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.register_et_email))
            .perform(ViewActions.typeText(filler_text), ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.register_btn_confirm)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.ProfileFrag_tv_username))
            .check(ViewAssertions.matches(ViewMatchers.withText(userName)))
    }
}