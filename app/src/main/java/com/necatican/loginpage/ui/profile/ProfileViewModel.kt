package com.necatican.loginpage.ui.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.necatican.loginpage.data.model.Items

class ProfileViewModel : ViewModel() {

    private var _user: MutableLiveData<Items?> = MutableLiveData()
    val user: LiveData<Items?> = _user

    private val db by lazy { FirebaseFirestore.getInstance() }

    init {
        getUserProfile()
    }

    private fun getUserProfile() {
        db.collection("users").document("3pClxZufiip2C1tl9A7f").get().addOnSuccessListener {
            if (it != null) {
                _user.value = it.toObject(Items::class.java)
                Log.d("okey", "Document ${user.value}")
            } else {
                Log.d("nope", "No document")
            }
        }
            .addOnFailureListener { exception ->
                Log.d("false", "get failed with ", exception)
            }

    }
}
