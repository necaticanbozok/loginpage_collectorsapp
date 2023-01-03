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
import com.necatican.loginpage.data.model.User
import com.necatican.loginpage.databinding.FragmentSignUpBinding


class SignUpFragment : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {
    private lateinit var database: DatabaseReference
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



binding.signupbutton2.setOnClickListener {

    val userName = binding.signupNameEditText.text.toString()
    val userSurname = binding.signupSurnameEditText.text.toString()
    val userMail = binding.signupMailEditText.text.toString()
    val userPassword = binding.signupPasswordEditText.text.toString()
    val confirmPass = binding.singupConfirmPassEditText.text.toString()

    if (userMail.isEmpty() && userPassword.isEmpty() && confirmPass.isEmpty()) {
        Toast.makeText(this.context, "Please fill the empty fields", Toast.LENGTH_SHORT)
            .show()
        return@setOnClickListener
    }
    if (userPassword != confirmPass){
        Toast.makeText(this.context,"Password must matched",Toast.LENGTH_SHORT)
            .show()
        return@setOnClickListener
    }
    firebaseAuth.createUserWithEmailAndPassword(userMail,userPassword)


    database = FirebaseDatabase.getInstance().getReference("Users")
    val User = User(userName, userSurname, userMail, userPassword , confirmPass)
    database.child(userName).setValue(User).addOnSuccessListener {
        binding.signupNameEditText.text.clear()
        binding.signupSurnameEditText.text.clear()
        binding.signupMailEditText.text.clear()
        binding.signupPasswordEditText.text.clear()
        binding.singupConfirmPassEditText.text.clear()





    }

    binding.signupbutton2.setOnClickListener {
        findNavController().navigate(R.id.action_signUpPage_to_loginPage)
    }

}
        binding.signupLoginButton.setOnClickListener {
            findNavController().navigate(R.id.action_signUpPage_to_loginPage)
        }


}

override fun isNavigationBarVisible() = false
}

