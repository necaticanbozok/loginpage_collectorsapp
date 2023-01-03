package com.necatican.loginpage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.necatican.loginpage.R
import com.necatican.loginpage.data.model.Items
import com.necatican.loginpage.data.model.User
import com.necatican.loginpage.data.model.UserList
import com.necatican.loginpage.databinding.ItemListedRecyclerViewBinding

class ListedItemsRVAdapter():RecyclerView.Adapter<ListedItemsRVAdapter.ItemViewHolder>(){
    private var list = emptyList<UserList>()
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(ItemListedRecyclerViewBinding.inflate(inflater,parent,false))
    }

    override fun getItemCount() = list.size

    class ItemViewHolder(val binding: ItemListedRecyclerViewBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(item: UserList) {
            binding.AdImage.setImageResource(R.drawable.listed_item1)
            binding.AdNameText.text = item.itemTitle
            binding.AdPrice.text = item.itemPrice
        }

    }

    fun setData(newList: List<UserList>){
        list = newList
        notifyDataSetChanged()
    }
}