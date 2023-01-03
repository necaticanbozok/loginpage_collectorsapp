package com.necatican.loginpage.ui.login

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.necatican.loginpage.R
import com.necatican.loginpage.base.BaseFragment
import com.necatican.loginpage.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val auth by lazy { FirebaseAuth.getInstance() }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.loginbutton2.setOnClickListener {

           signInUser(binding.loginMailEditText.text.toString(),
           binding.loginPasswordEditText.text.toString())
        }
        binding.loginSignupButton.setOnClickListener(){
            findNavController().navigate(R.id.action_loginPage_to_signUpPage)
        }


    }
    private fun signInUser(email:String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(ContentValues.TAG, "signInWithEmail:success")
                    updateUI(auth.currentUser)
                }else {
                    // If sign in fails, display a message to the user.
                    Log.w(ContentValues.TAG, "signInWithEmail:failure", task.exception)
                    updateUI(null)
                }
            }
    }
    private fun updateUI(user: FirebaseUser?) {
        if(user != null){
            findNavController().navigate(R.id.action_loginPage_to_mainPageFragment)
        }else {
            Toast.makeText(context,"Sign in failed",Toast.LENGTH_SHORT).show()
        }
    }

    override fun isNavigationBarVisible() = false


}


