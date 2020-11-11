package com.example.simplesocial.view.fragments

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.simplesocial.R
import com.example.simplesocial.model.data.SimpleSocialUser
import com.example.simplesocial.view.HomeScreenActivity
import com.example.simplesocial.viewmodel.AuthViewModel
import kotlinx.android.synthetic.main.fragment_registration.*
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegistrationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistrationFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    //private val model: AuthViewModel by activityViewModels()
    @Inject
    lateinit var factory: ViewModelProvider.Factory
    lateinit var model : AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        model = ViewModelProvider(this).get(AuthViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
                    register_et_verify,
                    register_et_birthday
                )){
                if(TextUtils.equals(register_et_password.text,register_et_verify.text)){
                    // rest of verification
                    // check if username exists

                    if(!model.checkUser(register_et_username.toString())){
                        val newUser = generateUser()
                        runBlocking {
                            model.registerUser(newUser)
                        }

                        //send the new user to the next Activity/Fragment bundle
                        val intent = Intent(activity, HomeScreenActivity::class.java)
                        intent.putExtra("user",newUser)
                        startActivity(intent)

                    } else {
                        val usernameHint = Toast.makeText(activity, "Username has been taken!", Toast.LENGTH_LONG)
                        usernameHint.show()
                    }
                } else {
                    val passwordHint = Toast.makeText(
                        activity,"Verify Passwords are the same", Toast.LENGTH_LONG)
                    passwordHint.show()
                }

            } else {
                val formHint = Toast.makeText(activity,"Please fill out the form", Toast.LENGTH_LONG)
                formHint.show()
            }


        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegistrationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegistrationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
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
            register_et_birthday.text.toString()
        )
    }
}