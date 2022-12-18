package com.necatican.loginpage

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.necatican.loginpage.base.BaseFragment
import com.necatican.loginpage.databinding.FragmentEnteranceBinding


class EnteranceFragment : BaseFragment<FragmentEnteranceBinding>(FragmentEnteranceBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginbutton.setOnClickListener {
            findNavController().navigate(R.id.action_enterencePage_to_loginPage)
        }
        binding.signupbutton.setOnClickListener {
            findNavController().navigate(R.id.action_enterencePage_to_signUpPage)
        }

        isNavigationBarVisible()
    }

    override fun isNavigationBarVisible()=false





}



