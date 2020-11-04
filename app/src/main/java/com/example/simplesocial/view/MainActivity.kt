package com.example.simplesocial.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.simplesocial.R
import com.example.simplesocial.databinding.ActivityMainBinding
import com.example.simplesocial.model.data.SimpleSocialUser
import com.example.simplesocial.viewmodel.ProfileViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        //Doing the ViewModel Thing
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        var binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        // Needed for the changes we were making
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

    }

    fun onClick(v : View){
        val intent = Intent(this,RegisterActivity::class.java)
        startActivity(intent)
    }

    fun loginVerify(v : View){
        var t = Toast.makeText(this@MainActivity, viewModel.username, Toast.LENGTH_LONG)
        //t.show()

        //Verify that the fields are filed out and give some level of feedback to the person entering the information.
        if((viewModel.username == "" || viewModel.password == "")){
            t = Toast.makeText(this, "Please enter a valid username and password", Toast.LENGTH_LONG)
            t.show()
        } else {
            // this is where the database check for the username and password will go.
            // using just a simple local data table. it will report and log in if it can find it it and if it can't then
            t = Toast.makeText(this, viewModel.username +" and password: "+ viewModel.password, Toast.LENGTH_LONG)
            t.show()

            // Currently just using the intent to pack away the object to start the program
            // todo do some actual verification of the user object against some kind of a database
            //currently creating the object

            var userBundle = SimpleSocialUser(
                "John",
                "Doe",
                viewModel.username,
                viewModel.password,
                "",
                "")

            val intent = Intent(this,HomeScreenActivity::class.java).apply {
                putExtra("user",userBundle)
            }
            startActivity(intent)
        }
        //Handle validation and pass the instance of the user object to the next instance of the viewModel/Class

    }
}