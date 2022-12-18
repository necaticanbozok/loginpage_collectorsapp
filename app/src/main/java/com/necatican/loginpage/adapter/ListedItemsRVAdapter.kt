package com.necatican.loginpage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.necatican.loginpage.R
import com.necatican.loginpage.data.model.Items
import kotlinx.android.synthetic.main.card_view_profile.view.*

class ListedItemsRVAdapter( itemList: ArrayList<Items>):RecyclerView.Adapter<ListedItemsRVAdapter.ItemViewHolder>(){

    var items=itemList
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var createdItem=items.get(position)
        holder?.setData(createdItem,position)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        var inflater = LayoutInflater.from(parent?.context)
        var card_view_profile = inflater.inflate(R.layout.card_view_profile,parent,false)

        return ItemViewHolder(card_view_profile)
    }

    override fun getItemCount(): Int {
        return items.size
    }
    class ItemViewHolder(card_view_profile:View):RecyclerView.ViewHolder(card_view_profile) {
         var single_item=card_view_profile as CardView

        var itemName= single_item.AdNameText
        var itemImage= single_item.AdImage
        var itemPrice=single_item.AdPrice

        fun setData(createdItem:Items,position: Int){
            itemName.text=createdItem.adName
            itemImage.setImageResource(createdItem.adImage)
        }
    }



}