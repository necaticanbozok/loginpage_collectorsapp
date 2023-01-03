package com.necatican.loginpage.ui.profile.edit_profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation
import com.google.android.material.bottomsheet.BottomSheetDialog
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
/*
        //Change photo bottomsheet
        val bottomSheetFragment = ChangePhotoBottomSheetFragment()
        binding.ChangePhotoBtn.setOnClickListener {
            bottomSheetFragment.show(childFragmentManager,"BottomSheet")
        }*/


    }

    override fun isNavigationBarVisible() = false
}



