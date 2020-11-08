package com.example.simplesocial.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.simplesocial.R
import com.example.simplesocial.databinding.FragmentProflieBinding
import com.example.simplesocial.model.data.SimpleSocialUser
import com.example.simplesocial.viewmodel.ProfileViewModel

private const val TAG = "ProfileFragment"

class ProfileFragment : Fragment() {
    private val model: ProfileViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentProflieBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_proflie, container, false)
        Log.d(TAG, "onCreateView: ${arguments?.get("user").toString()}")
        val users = arguments?.get("user") as SimpleSocialUser
        binding.root.findViewById<TextView>(R.id.ProfileFrag_tv_username).text = users.username
        model.user.value = arguments?.get("user") as SimpleSocialUser
        binding.viewModel = model
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(user: SimpleSocialUser) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("user", user)
                }
            }
    }
}