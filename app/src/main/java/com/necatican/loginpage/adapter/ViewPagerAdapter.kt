package com.necatican.loginpage.adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.necatican.loginpage.ui.profile.FavouriteItemsRVFragment
import com.necatican.loginpage.ui.profile.FavouriteSellersRVFragment
import com.necatican.loginpage.ui.profile.ListedItemsRVFragment


class ViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager,lifecycle){

    override fun getItemCount() = 3

     override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> ListedItemsRVFragment()
            1 -> FavouriteItemsRVFragment()
            2 -> FavouriteSellersRVFragment()
            else -> Fragment()
        }
    }
}