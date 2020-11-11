package com.example.simplesocial.view.fragments

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.simplesocial.R
import com.example.simplesocial.model.data.SimpleSocialUser
import com.example.simplesocial.view.HomeScreenActivity
import com.example.simplesocial.viewmodel.AuthViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_registration.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*
import javax.inject.Inject

class RegistrationFragment : Fragment() {
    private val model: AuthViewModel by activityViewModels()
    @Inject
    lateinit var factory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // moving the onclick binder to the bottom
        onClickBinderRegister()
    }

    // a function to check if the edittexts we are feeding the program have stuff in it
    private fun areEditTextsFilled(vararg strings: EditText?): Boolean {
        for (s in strings) if (s == null || s.text.isEmpty()) return false
        return true
    }

    private fun generateUser(): SimpleSocialUser{
        return SimpleSocialUser(
            register_et_fname.text.toString(),
            register_et_lname.text.toString(),
            register_et_username.text.toString(),
            register_et_verify.text.toString(),
            register_et_email.text.toString(),
            dateFunction(register_et_birthday)
        )
    }

    private fun dateFunction(datePicker: DatePicker) : String{
        val today = Calendar.getInstance()
        var msg = ""

        datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)

        ) { view, year, month, day ->
            val month = month + 1
            msg = "$day/$month/$year"
        }
        return msg
    }

    //on clickbinders
    private fun onClickBinderRegister(){
        //onclicks
        val confirmationBtn = register_btn_confirm
        confirmationBtn.setOnClickListener {

            // check to see if the fields are filled out
            if(areEditTextsFilled(
                    register_et_username,
                    register_et_fname,
                    register_et_lname,
                    register_et_password,
                    register_et_email,
                    register_et_password,
                    register_et_verify
                )){
                if(TextUtils.equals(register_et_password.text,register_et_verify.text)){
                    // check if username exists
                    if(model.checkUser(register_et_username.toString())){
                        val newUser = generateUser()
                        runBlocking {

                            model.registerUser(newUser)
                            //send the new user to the next Activity/Fragment bundle
                            val intent = Intent(activity, HomeScreenActivity::class.java)
                            intent.putExtra("user", newUser)
                            startActivity(intent)
                        }

                    } else {
                        register_tv_hint.text = "Username has been taken!"
                    }
                } else {
                    register_tv_hint.text = "Verify Passwords are the same."
                }

            } else {
                register_tv_hint.text = "Please fill out the form!"
            }
        }
    }
}