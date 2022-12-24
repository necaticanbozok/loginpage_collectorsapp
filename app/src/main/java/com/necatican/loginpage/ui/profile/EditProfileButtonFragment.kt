package com.necatican.loginpage.ui.profile

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.necatican.loginpage.R
import com.necatican.loginpage.base.BaseFragment
import com.necatican.loginpage.databinding.FragmentEditProfileButtonBinding


class EditProfileButtonFragment :
    BaseFragment<FragmentEditProfileButtonBinding>(FragmentEditProfileButtonBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        isNavigationBarVisible()

        //Action to navigate profile
        binding.CloseButton.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_editProfileButtonFragment_to_profileFragment)
        }


    }

    override fun isNavigationBarVisible() = false
}



