package com.example.android.ecommerce.ui.mainlisting

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.ecommerce.R
import com.example.android.ecommerce.constants.PARCEL
import com.example.android.ecommerce.databinding.ItemListBinding
import com.example.android.ecommerce.listeners.Callbacks
import com.example.android.ecommerce.model.Product

class ProductListAdapter(private val context: Activity, private var mList: List<Product?>?, private val _onEventCallback : Callbacks.Callback?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val onEventCallback: Callbacks.Callback? = _onEventCallback

    fun setList(mList: List<Product>) {
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        val binding = ItemListBinding.bind(itemView)
        return ItemViewHolder(binding, itemView)
    }

    override fun getItemCount(): Int {
        return mList?.size ?:0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder){
            if (!mList.isNullOrEmpty()) {
                holder.binding.itemTvTitle.text = mList?.let { mList -> mList[position]?.name }
            }
        }
    }

    inner class ItemViewHolder(
        val binding: ItemListBinding,
        itemView: View
    ) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            val position: Int = adapterPosition
            val product: Product? = mList?.let { mList -> mList[position] }
            val intent = Intent()
            intent.putExtra(PARCEL, product)
            onEventCallback?.onEventCallBack(intent)
        }
    }
}