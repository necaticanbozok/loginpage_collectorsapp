package com.necatican.loginpage.ui.login

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.necatican.loginpage.R
import com.necatican.loginpage.base.BaseFragment
import com.necatican.loginpage.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_profile.*


class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {


    private lateinit var database: DatabaseReference
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userMail = login_mail_editText.text.toString()
        val userPassword = login_password_editText.text.toString()

        binding.loginbutton2.setOnClickListener {
            val userMail: String = binding.loginMailEditText.text.toString()
            val userPassword: String = binding.loginPasswordEditText.text.toString()
            if (userMail.isNotEmpty()) {
                if (userPassword.isNotEmpty()) {
                    Toast.makeText(this.context,"Login Successfull",Toast.LENGTH_SHORT).show()

                    findNavController().navigate(R.id.action_loginPage_to_mainPageFragment)

                }else{
                    Toast.makeText(this.context, "Please Enter Your Password", Toast.LENGTH_SHORT)
                        .show()
                }

            }else{
                Toast.makeText(this.context, "Please Enter Your Email", Toast.LENGTH_SHORT).show()

            }


        }
        binding.loginSignupButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginPage_to_signUpPage)
        }
    }
    override fun isNavigationBarVisible() = false


}





