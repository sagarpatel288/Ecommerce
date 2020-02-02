package com.example.android.ecommerce.model

import android.annotation.SuppressLint
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class Category(
    @SerializedName("child_categories")
    var childCategories: List<Category?>? = null,
    @SerializedName("id")
    var id: Long = 0, // 13
    @SerializedName("name")
    var name: String? = null, // Laptops
    @SerializedName("products")
    var products: List<Product?>? = null
) : Parcelable