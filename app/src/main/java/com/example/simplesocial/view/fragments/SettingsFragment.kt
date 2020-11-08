package com.example.simplesocial.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.simplesocial.R
import com.example.simplesocial.databinding.FragmentSettingsBinding
import com.example.simplesocial.model.data.SimpleSocialUser
import com.example.simplesocial.viewmodel.ProfileViewModel


class SettingsFragment : Fragment() {
    private val model: ProfileViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentSettingsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false)
        //model.user.value = arguments?.get("user") as SimpleSocialUser
        Log.v("user_settings", model.user.toString())
        Log.v("user_settings", model.user.value.toString())
        binding.viewModel = model
        return binding.root
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SettingsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(user: SimpleSocialUser) =
            SettingsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("user", user)
                }
            }
    }
}