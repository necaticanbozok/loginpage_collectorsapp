package com.necatican.loginpage.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.necatican.loginpage.data.model.User


class LoginViewModel:ViewModel() {

    private val currentUser by lazy { FirebaseAuth.getInstance().currentUser!!.uid }
    private val db by lazy { FirebaseFirestore.getInstance() }
    val isSeen: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }

    fun isOldUser(){
        db.collection("users").document(currentUser).get().addOnSuccessListener {
            isSeen.value = (it.toObject(User::class.java) as User).userName!=""
        }
    }


}