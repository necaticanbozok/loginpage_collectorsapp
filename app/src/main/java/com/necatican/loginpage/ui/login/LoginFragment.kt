package com.necatican.loginpage.ui.login

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.necatican.loginpage.R
import com.necatican.loginpage.base.BaseFragment
import com.necatican.loginpage.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.activity_main.*


class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        isNavigationBarVisible()

        binding.loginbutton2.setOnClickListener(){
            findNavController().navigate(R.id.action_loginPage_to_mainPageFragment)
        }
        binding.loginSignupButton.setOnClickListener(){
            findNavController().navigate(R.id.action_loginPage_to_signUpPage)
        }


    }

    override fun isNavigationBarVisible() = false


}


