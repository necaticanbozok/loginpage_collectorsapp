package com.necatican.loginpage.ui.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.necatican.loginpage.data.model.Items
import com.necatican.loginpage.data.model.User

class ProfileViewModel : ViewModel() {

    private var _user: MutableLiveData<User?> = MutableLiveData()
    val user: LiveData<User?> = _user

    private val db by lazy { FirebaseFirestore.getInstance() }
    private val auth by lazy { FirebaseAuth.getInstance() }

    init {
        getUserProfile()
    }

    private fun getUserProfile() {
        db.collection("MyUser").document(auth.currentUser!!.uid).get().addOnSuccessListener {
            if (it != null) {
                _user.value = it.toObject(User::class.java)
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
