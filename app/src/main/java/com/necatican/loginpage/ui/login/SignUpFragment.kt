package com.necatican.loginpage.ui.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.necatican.loginpage.R
import com.necatican.loginpage.base.BaseFragment
import com.necatican.loginpage.data.model.User
import com.necatican.loginpage.databinding.FragmentSignUpBinding
import kotlinx.android.synthetic.main.fragment_profile.*


class SignUpFragment : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {
    private lateinit var database: DatabaseReference
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signupbutton2.setOnClickListener {

            val userName = binding.signupNameEditText.text.toString()
            val userSurname = binding.signupSurnameEditText.text.toString()
            val userMailAddress = binding.singupMailEditText.text.toString()
            val userPassword = binding.signupPasswordEditText.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Users")
            val User = User(userName, userSurname, userMailAddress, userPassword)
            database.child(userName).setValue(User).addOnSuccessListener {
                binding.signupNameEditText.text.clear()
                binding.signupSurnameEditText.text.clear()
                binding.singupMailEditText.text.clear()
                binding.signupPasswordEditText.text.clear()


            }


            binding.signupLoginButton.setOnClickListener {
                findNavController().navigate(R.id.action_signUpPage_to_loginPage)
            }
            binding.signupbutton2.setOnClickListener {
                findNavController().navigate(R.id.action_signUpPage_to_mainPageFragment)
            }
        }


    }

    override fun isNavigationBarVisible() = false
}
