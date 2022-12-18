package com.necatican.loginpage.ui.profile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.necatican.loginpage.R
import com.necatican.loginpage.adapter.ListedItemsRVAdapter
import com.necatican.loginpage.base.BaseFragment
import com.necatican.loginpage.data.model.Items
import com.necatican.loginpage.databinding.FragmentProfileBinding

class FavouriteSellersRVFragment(currentArgId: Int) :  BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {
    var listingItems = ArrayList<Items>()
    private lateinit var listItemRecyclerView: RecyclerView
    private lateinit var adapter:ListedItemsRVAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_listed_items_rv,container,false)

        listItemRecyclerView = view.findViewById(R.id.listItemRecyclerView)
        adapter= ListedItemsRVAdapter(listingItems)
        listItemRecyclerView.adapter=adapter
        var MylayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        listItemRecyclerView.layoutManager=MylayoutManager
        return view
    }

}