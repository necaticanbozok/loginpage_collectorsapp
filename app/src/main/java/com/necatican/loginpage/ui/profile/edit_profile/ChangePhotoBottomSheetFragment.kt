package com.necatican.loginpage.ui.profile.edit_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.necatican.loginpage.R
import kotlinx.android.synthetic.main.fragment_change_photo_bottom_sheet.*


class ChangePhotoBottomSheetFragment : BottomSheetDialogFragment() {
    companion object{
        const val REQUEST_FROM_CAMERA= 1001;
        const val REQUEST_FROM_GALLERY= 1001;

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_change_photo_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        take_photo.setOnClickListener {
            captureUsingCamera()

        }

        pick_gallery.setOnClickListener {
            pickPhotoFromGallery()

        }

    }


    private fun captureUsingCamera() {
        //ImagePicker.with(ChangePhotoBottomSheetFragment).cameraOnly()
    }

    private fun pickPhotoFromGallery() {
        TODO("Not yet implemented")
    }


}

