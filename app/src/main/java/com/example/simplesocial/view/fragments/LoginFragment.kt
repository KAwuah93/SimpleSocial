package com.example.simplesocial.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.simplesocial.R
import com.example.simplesocial.model.data.SimpleSocialUser
import com.example.simplesocial.view.HomeScreenActivity
import com.example.simplesocial.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private val model : ProfileViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_login, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Creating the onclick functions for the movement of the application
        val registerBtn = LoginFrag_btn_Register
        registerBtn.setOnClickListener{
            val fragment = RegistrationFragment()
            val fragmentManager = activity?.supportFragmentManager
            val fragmentTransaction = fragmentManager!!.beginTransaction()
            fragmentTransaction.replace(R.id.main_fl_screen,fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        // todo create the onclick for login btn
        // probably don't even need it can connect it directly to
        val loginBtn = LoginFrag_btn_Login
        loginBtn.setOnClickListener{
            // todo have actual validation instead of this.
            // viewModel Verification method
            val intent = Intent(activity,HomeScreenActivity::class.java)

            //create test data just to send it off
            var testData = SimpleSocialUser()
            testData.fName = "Kwame"
            testData.lName = "Awuah"
            testData.username = "Kawuah93"

            intent.putExtra("user",testData)

            startActivity(intent)
        }
    }
}