package com.example.simplesocial.view.fragments

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.simplesocial.R
import com.example.simplesocial.model.data.SimpleSocialUser
import com.example.simplesocial.view.HomeScreenActivity
import com.example.simplesocial.viewmodel.AuthViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class LoginFragment : Fragment() {

    private val model : AuthViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Creating the onclick functions for the movement of the application
        LoginFrag_btn_Login.isEnabled = false
        // attaching the textWatcher to both edit texts
        watchLoginInformation(loginFrag_et_password)
        watchLoginInformation(loginFrag_et_username)
        // set up the
        onClickBinders()
    }

    //
    private fun onClickBinders(){
        val registerBtn = LoginFrag_btn_Register
        registerBtn.setOnClickListener{
            val fragment = RegistrationFragment()
            val fragmentManager = activity?.supportFragmentManager
            val fragmentTransaction = fragmentManager!!.beginTransaction()
            fragmentTransaction.replace(R.id.main_fl_screen,fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }


        val loginBtn = LoginFrag_btn_Login
        loginBtn.setOnClickListener{

            var data: SimpleSocialUser? = null
            lifecycleScope.launch(Dispatchers.IO) {
                try {
                    data = model.verifyUser(
                        loginFrag_et_username.text.toString(),
                        loginFrag_et_password.text.toString()
                    )
                    withContext(Dispatchers.Main){
                        if (data != null) {
                            val intent = Intent(activity, HomeScreenActivity::class.java)

                            intent.putExtra("user", data)
                            startActivity(intent)
                        } else {
                            loginFrag_tv_hint.text = "Please check Login info!"
                        }
                    }
                } catch (e : Exception){
                    Log.e("ASYNC", "$e")
                }
            }
        }
    }

    // creation of the button check util
    private fun watchLoginInformation(fieldVar : EditText){

        fieldVar.addTextChangedListener( object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val passwordInput = loginFrag_et_password.text.toString().trim()
                val usernameInput = loginFrag_et_username.text.toString().trim()
                LoginFrag_btn_Login.isEnabled = (passwordInput.isNotEmpty() && usernameInput.isNotEmpty())
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }
}