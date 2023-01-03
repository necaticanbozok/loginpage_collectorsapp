package com.necatican.loginpage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.necatican.loginpage.R
import com.necatican.loginpage.data.model.Items
import com.necatican.loginpage.data.model.SellersList
import com.necatican.loginpage.databinding.FavouriteSellersRecyclerViewBinding
import com.necatican.loginpage.databinding.ItemListedRecyclerViewBinding
import com.necatican.loginpage.ui.profile.FavouriteSellersRVFragment

class FavouriteSellersRVAdapter: RecyclerView.Adapter<FavouriteSellersRVAdapter.ItemViewHolder>(){
    private var list = emptyList<SellersList>()
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(FavouriteSellersRecyclerViewBinding.inflate(inflater,parent,false))
    }

    override fun getItemCount() = list.size

    class ItemViewHolder(val binding: FavouriteSellersRecyclerViewBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SellersList) {
            binding.AdImage.setImageResource(R.drawable.listed_item1)
            binding.profileUserName.text=item.userName

        }

    }

    fun setData(newList: List<SellersList>){
        list = newList
        notifyDataSetChanged()
    }
}