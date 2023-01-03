package com.necatican.loginpage.ui.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.necatican.loginpage.R
import com.necatican.loginpage.base.BaseFragment
import com.necatican.loginpage.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_profile.*


class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {


    private lateinit var database: DatabaseReference
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()





        binding.loginbutton2.setOnClickListener {
            val userMail: String = binding.loginMailEditText.text.toString()
            val userPassword: String = binding.loginPasswordEditText.text.toString()
            if (userMail.isEmpty()){
                Toast.makeText(this.context,"Please Enter Your Email",Toast.LENGTH_SHORT).show()
            }
            if (userPassword.isEmpty()){
                Toast.makeText(this.context,"Please Enter Your Password",Toast.LENGTH_SHORT).show()

            }
            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(userName.toString()).get().addOnSuccessListener {
            if (it.exists()) {
                firebaseAuth.signInWithEmailAndPassword(userMail,
                    userPassword
                )
                it.child("userMail").value
                it.child("userPassword").value
                Toast.makeText(this.context, "Login Successful", Toast.LENGTH_SHORT).show()
                binding.loginMailEditText.text.clear()
                binding.loginPasswordEditText.text.clear()
            }
        }
        }
                binding.loginSignupButton.setOnClickListener {
                    findNavController().navigate(R.id.action_loginPage_to_signUpPage)
                }





    }



    override fun isNavigationBarVisible() = false
}





