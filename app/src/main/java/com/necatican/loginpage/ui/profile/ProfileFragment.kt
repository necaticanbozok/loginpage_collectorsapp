package com.necatican.loginpage.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.necatican.loginpage.R
import com.necatican.loginpage.adapter.ViewPagerAdapter
import com.necatican.loginpage.base.BaseFragment
import com.necatican.loginpage.databinding.FragmentProfileBinding


class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {
    //TabLayout
    private val tabLayoutfragmentList = ArrayList<Fragment>()//creating list for fragments
    private val tabLayoutFragmentTitleTagList = ArrayList<String>()
    private val viewModel by viewModels<ProfileViewModel>()

    //Firebase database call
    private val db by lazy { FirebaseFirestore.getInstance() }
    private val auth by lazy { FirebaseAuth.getInstance() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //adding rv fragments to fragmentlist
        tabLayoutfragmentList.add(ListedItemsRVFragment())
        tabLayoutfragmentList.add(FavouriteItemsRVFragment())
        tabLayoutfragmentList.add(FavouriteSellersRVFragment())

        //creating adapter object from viewpagerdapter in order to connect
        val adapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        binding.viewpager2.adapter = adapter

        //adding title
        tabLayoutFragmentTitleTagList.add("Listed Items")
        tabLayoutFragmentTitleTagList.add("Favourite Items")
        tabLayoutFragmentTitleTagList.add("Favourite Sellers")

        TabLayoutMediator(binding.tablayout, binding.viewpager2) { tab, position ->
            tab.setText(tabLayoutFragmentTitleTagList[position])
        }.attach()

        //Action to navigate edit profile
        binding.editProfileButton.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_profileFragment_to_editProfileButtonFragment)
        }

        //observing username
        viewModel.user.observe(viewLifecycleOwner) {
            binding.userName.text = it?.adName
        }
    }


}
