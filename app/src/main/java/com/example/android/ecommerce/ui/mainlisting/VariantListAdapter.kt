package com.example.android.ecommerce.ui.mainlisting

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.ecommerce.R
import com.example.android.ecommerce.constants.PARCEL
import com.example.android.ecommerce.databinding.ItemVariantListBinding
import com.example.android.ecommerce.listeners.Callbacks
import com.example.android.ecommerce.model.Variant

class VariantListAdapter(private val context: Activity, private var mList: List<Variant?>?, private val _onEventCallback : Callbacks.Callback?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val onEventCallback: Callbacks.Callback? = _onEventCallback

    fun setList(mList: List<Variant>) {
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_variant_list, parent, false)
        val binding = ItemVariantListBinding.bind(itemView)
        return ItemViewHolder(binding, itemView)
    }

    override fun getItemCount(): Int {
        return mList?.size ?:0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder){
            if (!mList.isNullOrEmpty()) {
                holder.binding.itemTvColorValue.text = mList?.let { mList -> mList[position]?.color }
                holder.binding.itemTvSizeValue.text = mList?.let { mList -> mList[position]?.size }.toString()
                holder.binding.itemTvPriceValue.text = mList?.let { mList -> mList[position]?.price }.toString()
            }
        }
    }

    inner class ItemViewHolder(
        val binding: ItemVariantListBinding,
        itemView: View
    ) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            val position: Int = adapterPosition
            val variant: Variant? = mList?.let { mList -> mList[position] }
            val intent = Intent()
            intent.putExtra(PARCEL, variant)
            onEventCallback?.onEventCallBack(intent)
        }
    }
}