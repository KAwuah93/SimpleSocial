package com.example.simplesocial.view.fragments

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.simplesocial.R
import com.example.simplesocial.databinding.FragmentProflieBinding
import com.example.simplesocial.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_proflie.*


class ProfileFragment : Fragment() {
    //pulls instance of viewModel from the activity that it is bound to for data sharingdd
    private val model: ProfileViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentProflieBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_proflie, container, false)
        binding.viewModel = model
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindButtons()
    }

    // onbind for both views
    private fun bindButtons() {
        ProfileFrag_btn_Settings.setOnClickListener {
            val fragment = SettingsFragment()
            val fragmentManager = activity?.supportFragmentManager
            val fragmentTransaction = fragmentManager!!.beginTransaction()
            fragmentTransaction.replace(R.id.Home_fv_screen, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        ProfileFrag_btn_logout.setOnClickListener {
            // delete the entry in the shared preference with a null check and then send back to login screen

        }

        ProfileFrag_img_avi.setOnClickListener {
        capturePhoto()
        }
    }

    fun capturePhoto() {

        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, 200)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 200 && data != null){
            ProfileFrag_img_avi.setImageBitmap(data.extras?.get("data") as Bitmap)
        }
    }

}