package com.necatican.loginpage.ui.profile

import android.os.Bundle
import android.view.View
import com.necatican.loginpage.R
import com.necatican.loginpage.adapter.FavouriteSellersRVAdapter
import com.necatican.loginpage.adapter.ListedItemsRVAdapter
import com.necatican.loginpage.base.BaseFragment
import com.necatican.loginpage.data.model.Items
import com.necatican.loginpage.data.model.SellersList
import com.necatican.loginpage.databinding.FragmentFavouriteSellersRvBinding

class FavouriteSellersRVFragment(val items : List<SellersList>) :  BaseFragment<FragmentFavouriteSellersRvBinding>(FragmentFavouriteSellersRvBinding::inflate) {
    private val adapter by lazy { FavouriteSellersRVAdapter() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.setData(items)
        binding.favouriteSellersRV.adapter = adapter
    }


}