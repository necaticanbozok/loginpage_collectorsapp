package com.necatican.loginpage.ui.login

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.necatican.loginpage.R
import com.necatican.loginpage.base.BaseFragment
import com.necatican.loginpage.databinding.FragmentSignUpBinding


class SignUpFragment : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signupLoginButton.setOnClickListener {
            findNavController().navigate(R.id.action_signUpPage_to_loginPage)
        }
        binding.signupbutton2.setOnClickListener {
            findNavController().navigate(R.id.action_signUpPage_to_deneme)
        }
    }

    override fun isNavigationBarVisible() = false


}