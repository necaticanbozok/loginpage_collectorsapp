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
import com.necatican.loginpage.data.model.UserList
import com.necatican.loginpage.databinding.FragmentListedItemsRvBinding


class ListedItemsRVFragment(val items: List<UserList>) : BaseFragment<FragmentListedItemsRvBinding>(FragmentListedItemsRvBinding::inflate){
    private val adapter by lazy { ListedItemsRVAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.setData(items)
        binding.listItemRecyclerView.adapter = adapter
    }


}