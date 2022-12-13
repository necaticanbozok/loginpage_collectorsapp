package com.necatican.loginpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.google.firebase.database.FirebaseDatabase
import com.necatican.loginpage.R.*
import com.necatican.loginpage.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity


class signUpPage : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var database = FirebaseDatabase.getInstance().reference

        //veri ekleme
        binding.navHost.setOnClickListener(){
            var signup_name = binding.navHost.findViewById<>(R.id.signup_name_editText)

        }


    }

    fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val layout_signup= inflater.inflate(layout.fragment_sign_up_page,container,false)
        val button_signup= layout_signup.findViewById<Button>(R.id.signupbutton2)
        button_signup.setOnClickListener(){
            layout_signup.findNavController().navigate(R.id.action_signUpPage_to_loginPage)
        }
        val button_have_acc= layout_signup.findViewById<Button>(R.id.signup_login_button)
        button_have_acc.setOnClickListener(){
            layout_signup.findNavController().navigate(R.id.action_signUpPage_to_loginPage)
        }

        return layout_signup
        // Inflate the layout for this fragment

    }


}