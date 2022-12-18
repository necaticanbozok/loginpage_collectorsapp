package com.necatican.loginpage.adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.necatican.loginpage.MainActivity
import com.necatican.loginpage.ui.profile.FavouriteItemsRVFragment
import com.necatican.loginpage.ui.profile.FavouriteSellersRVFragment
import com.necatican.loginpage.ui.profile.ListedItemsRVFragment


class ViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager,lifecycle){

    private var currentArgId =0
    override fun getItemCount() = 3

     override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> ListedItemsRVFragment(currentArgId)
            1 -> FavouriteItemsRVFragment(currentArgId)
            2 -> FavouriteSellersRVFragment(currentArgId)
            else -> Fragment()
        }
    }
    fun setArg(id: Int){
        currentArgId = id
    }

}