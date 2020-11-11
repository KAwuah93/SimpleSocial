package com.example.simplesocial.view

import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.simplesocial.R
import com.example.simplesocial.model.data.SimpleSocialUser
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SimpleSocialProfileFragUITests{
    val testUser = generateUser()
    val intent = generateIntent()

    @get:Rule
    var activityRule : ActivityScenarioRule<MainActivity> = ActivityScenarioRule(intent)

    @Test
    fun profileFrag_matchingUserInfo(){
        onView(withId(R.id.ProfileFrag_tv_username))
            .check(ViewAssertions.matches(ViewMatchers.withText(testUser.username)))

        onView(withId(R.id.ProfileFrag_tv_fName))
            .check(ViewAssertions.matches(ViewMatchers.withText(testUser.fName)))

        onView(withId(R.id.ProfileFrag_tv_lName))
            .check(ViewAssertions.matches(ViewMatchers.withText(testUser.lName)))
    }

    @Test
    fun settings_matchingUserInfo(){
        onView(withId(R.id.ProfileFrag_btn_Settings)).perform(click())

        onView(withId(R.id.settings_tv_username))
            .check(ViewAssertions.matches(ViewMatchers.withText(testUser.username)))
        onView(withId(R.id.settings_et_fname))
            .check(ViewAssertions.matches(ViewMatchers.withText(testUser.fName)))
        onView(withId(R.id.settings_et_lname))
            .check(ViewAssertions.matches(ViewMatchers.withText(testUser.lName)))
    }

    @Test
    fun settings_editMatchingUserInfo(){
        onView(withId(R.id.ProfileFrag_btn_Settings)).perform(click())

        onView(withId(R.id.settings_et_fname)).perform(ViewActions.clearText())
        onView(withId(R.id.settings_et_fname))
            .perform(ViewActions.typeText("Arlo"), ViewActions.closeSoftKeyboard())

        onView(withId(R.id.settings_et_lname)).perform(ViewActions.clearText())
        onView(withId(R.id.settings_et_lname))
            .perform(ViewActions.typeText("Jameson"), ViewActions.closeSoftKeyboard())

        onView(withId(R.id.Settings_btn_confirm)).perform(click())

        onView(withId(R.id.ProfileFrag_tv_username))
            .check(ViewAssertions.matches(ViewMatchers.withText(testUser.username)))

        onView(withId(R.id.ProfileFrag_tv_fName))
            .check(ViewAssertions.matches(ViewMatchers.withText("Arlo")))

        onView(withId(R.id.ProfileFrag_tv_lName))
            .check(ViewAssertions.matches(ViewMatchers.withText("Jameson")))
    }


    private fun generateIntent(): Intent{
        val intent = Intent(ApplicationProvider.getApplicationContext(), HomeScreenActivity::class.java)
        intent.putExtra("user", testUser)
        return intent
    }

    private fun generateUser(): SimpleSocialUser{
        var user = SimpleSocialUser()
        user.username = "JohnnyShreds212"
        return user
    }

}