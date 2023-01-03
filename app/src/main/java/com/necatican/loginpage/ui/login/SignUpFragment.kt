package com.necatican.loginpage.ui.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.necatican.loginpage.R
import com.necatican.loginpage.base.BaseFragment
import com.necatican.loginpage.data.model.SellersList
import com.necatican.loginpage.data.model.User
import com.necatican.loginpage.data.model.UserList
import com.necatican.loginpage.databinding.FragmentSignUpBinding


class SignUpFragment : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {
   private val auth by lazy { FirebaseAuth.getInstance() }
   private val database by lazy { FirebaseFirestore.getInstance() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signupbutton2.setOnClickListener {
            if (isValid()){
                auth.createUserWithEmailAndPassword(binding.signupMailEditText.text.toString(),
                binding.signupPasswordEditText.text.toString()).addOnSuccessListener {
                    addUserToCollection()
                    findNavController().navigate(R.id.action_signUpPage_to_loginPage)
                }.addOnFailureListener { Toast.makeText(requireContext(),"SignUp Failed",Toast.LENGTH_LONG).show() }

            }
        }
    }
    private fun addUserToCollection(){
        database.collection("MyUser").document(auth.currentUser!!.uid)
            .set(User(
                userName =binding.signupNameEditText.text.toString(),
                userSurname = binding.signupSurnameEditText.text.toString(),
                userPassword = binding.signupPasswordEditText.text.toString(),
                userMail = binding.signupMailEditText.text.toString(),
                favouriteList = mutableListOf(UserList("100","ilan 1")
                    ,UserList("200","ilan 2")),
                favouriteSellersList = mutableListOf(SellersList("emre")),
                itemList = mutableListOf(UserList("300","ilan 3"))

            ))
    }
    private fun isValidPassword():Boolean{
        return binding.signupPasswordEditText.text.toString() == binding.singupConfirmPassEditText.text.toString()
    }
    private fun isValid():Boolean{
        var valid=false
         if(isValidPassword()){
            if(binding.signupPasswordEditText.text.isNotEmpty() && binding.signupMailEditText.text.isNotEmpty() &&
                binding.signupNameEditText.text.isNotEmpty() && binding.signupSurnameEditText.text.isNotEmpty() &&
                    binding.singupConfirmPassEditText.text.isNotEmpty()){

                valid=true
            }
        }
        return  valid
    }

    override fun isNavigationBarVisible() = false
}

