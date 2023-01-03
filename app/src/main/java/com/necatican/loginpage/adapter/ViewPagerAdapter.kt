package com.necatican.loginpage.adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.necatican.loginpage.data.model.SellersList
import com.necatican.loginpage.data.model.UserList
import com.necatican.loginpage.ui.profile.FavouriteItemsRVFragment
import com.necatican.loginpage.ui.profile.FavouriteSellersRVFragment
import com.necatican.loginpage.ui.profile.ListedItemsRVFragment


class ViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager,lifecycle){

    override fun getItemCount() = 3
    private var userList = mutableListOf<UserList>()
    private var favList = mutableListOf<UserList>()
    private var sellersList = mutableListOf<SellersList>()

     override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> ListedItemsRVFragment(userList)
            1 -> FavouriteItemsRVFragment(favList)
            2 -> FavouriteSellersRVFragment(sellersList)
            else -> Fragment()
        }
    }
    fun setUserList(list: List<UserList>){
        userList = list as MutableList<UserList>
    }
    fun setSellerList(list: List<SellersList>){
        sellersList = list as MutableList<SellersList>
    }
    fun setFavList(list: List<UserList>){
        favList = list as MutableList<UserList>
    }

}