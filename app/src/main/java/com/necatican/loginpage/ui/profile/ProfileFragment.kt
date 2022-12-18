package com.necatican.loginpage.ui.profile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.tabs.TabLayoutMediator
import com.necatican.loginpage.R
import com.necatican.loginpage.adapter.ListedItemsRVAdapter
import com.necatican.loginpage.adapter.ViewPagerAdapter
import com.necatican.loginpage.base.BaseFragment
import com.necatican.loginpage.data.model.Items
import com.necatican.loginpage.databinding.FragmentProfileBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_edit_profile_button.*
import kotlinx.android.synthetic.main.fragment_edit_profile_button.view.*
import kotlinx.android.synthetic.main.fragment_listed_items_rv.*
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {
    //TabLayout
    private val tabLayoutfragmentList = ArrayList<Fragment>()//creating list for fragments
    private val tabLayoutFragmentTitleTagList = ArrayList<String>()


    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //initTabs()
        isNavigationBarVisible()
        //adding rv fragments to fragmentlist
        tabLayoutfragmentList.add(ListedItemsRVFragment(currentArgId = 0))
        tabLayoutfragmentList.add(FavouriteItemsRVFragment(currentArgId =1 ))
        tabLayoutfragmentList.add(FavouriteSellersRVFragment(currentArgId = 2))

    //creating adapter object from viewpagerdapter in order to connect
    val adapter = ViewPagerAdapter(childFragmentManager,lifecycle)
    binding.viewpager2.adapter=adapter

        //adding title
        tabLayoutFragmentTitleTagList.add("Listed Items")
        tabLayoutFragmentTitleTagList.add("Favourite Items")
        tabLayoutFragmentTitleTagList.add("Favourite Sellers")

        TabLayoutMediator(binding.tablayout,binding.viewpager2){tab,position ->
            tab.setText(tabLayoutFragmentTitleTagList[position])
        }.attach()

        //Action to navigate edit profile
        binding.editProfileButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_profileFragment_to_editProfileButtonFragment)
        }
        /*Close tab button at edit profile
        binding.CloseTabBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_editProfileButtonFragment_to_profileFragment)
        }*/


    }







/* SERHAD ABİ'NİN REPODAKİ KODLAR

    private val adapter by lazy { ViewPagerAdapter(childFragmentManager,lifecycle) }
    private val fragmentArray = arrayOf("Listed Items","Favourite Items","Favourite Sellers")
    private val args: ProfileFragmentArgs by navArgs()


    private fun initTabs(){
        adapter.setArg(args.id)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = fragmentArray[position]
        }.attach()
    }
*/
}
