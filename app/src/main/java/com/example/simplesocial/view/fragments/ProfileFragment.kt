package com.example.simplesocial.view.fragments

import android.os.Bundle
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

        //place the onclicks for the views
        ProfileFrag_btn_Settings.setOnClickListener{
            val fragment = SettingsFragment()
            val fragmentManager = activity?.supportFragmentManager
            val fragmentTransaction = fragmentManager!!.beginTransaction()
            fragmentTransaction.replace(R.id.Home_fv_screen, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }

}