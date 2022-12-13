package com.necatican.loginpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.necatican.loginpage.R.*
import com.necatican.loginpage.R.id.loginbutton


class loginPage : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val layout_login = inflater.inflate(layout.fragment_login_page,container,false)
        val button_login = layout_login.findViewById<Button>(R.id.loginbutton2)
        button_login.setOnClickListener(){
            layout_login.findNavController().navigate(R.id.action_loginPage_to_deneme)
        }
        val button_dont_have_acc = layout_login.findViewById<Button>(R.id.login_signup_button)
        button_dont_have_acc.setOnClickListener(){
            layout_login.findNavController().navigate(R.id.action_loginPage_to_signUpPage)
        }

        return layout_login

        


    }



}


