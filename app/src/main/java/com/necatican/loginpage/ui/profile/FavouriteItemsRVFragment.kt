package com.necatican.loginpage.ui.profile

import android.os.Bundle
import android.view.View
import com.necatican.loginpage.R
import com.necatican.loginpage.adapter.ListedItemsRVAdapter
import com.necatican.loginpage.base.BaseFragment
import com.necatican.loginpage.data.model.Items
import com.necatican.loginpage.databinding.FragmentFavouriteItemsRvBinding

class FavouriteItemsRVFragment :  BaseFragment<FragmentFavouriteItemsRvBinding>(FragmentFavouriteItemsRvBinding::inflate) {
    private val adapter by lazy { ListedItemsRVAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.setData(loadData())
        binding.favoriteRv.adapter = adapter
    }

    private fun loadData() : List<Items>{
        val myList = mutableListOf<Items>()
        for (i in 1..5) {
            myList.add(Items(adImage = R.drawable.listed_item1, adName = "$i.Emre", adPrice = "$i"))
        }
        return  myList
    }
}