package com.necatican.loginpage


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.necatican.loginpage.databinding.ActivityMainBinding
import com.necatican.loginpage.ui.main.MainPageFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_enterance.*


class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigation.setupWithNavController(
            navController
        )


        //val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
       // NavigationUI.setupWithNavController(bottom_navigation,navHostFragment.navController)


    }

    fun hideNavigationBar() {
        bottom_navigation.visibility=View.GONE
    //bottomNavigation.visibility = View.GONE
    }

    fun showNavigationBar() {

        bottom_navigation.visibility=View.VISIBLE
    }


}

