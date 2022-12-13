package com.necatican.loginpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.necatican.loginpage.R.*
import com.necatican.loginpage.R.id.loginbutton


class EnterencePage : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val layout= inflater.inflate(layout.fragment_enterence_page,container,false)
        val button_login=layout.findViewById<Button>(loginbutton)
        button_login.setOnClickListener(){
            Navigation.findNavController(it).navigate(R.id.action_enterencePage_to_loginPage)

        }
        val button_signup=layout.findViewById<Button>(R.id.signupbutton)
        button_signup.setOnClickListener(){
            Navigation.findNavController(it).navigate(R.id.action_enterencePage_to_signUpPage)
        }



        // Inflate the layout for this fragment
        return layout
    }


}



