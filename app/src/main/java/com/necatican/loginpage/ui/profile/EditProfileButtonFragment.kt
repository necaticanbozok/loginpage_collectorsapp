package com.necatican.loginpage.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.necatican.loginpage.R
import com.necatican.loginpage.base.BaseFragment
import com.necatican.loginpage.databinding.FragmentProfileBinding


class EditProfileButtonFragment :  BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_profile_button, container, false)
        isNavigationBarVisible()
    }

    override fun isNavigationBarVisible()=false
}