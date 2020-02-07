package com.example.android.ecommerce.model

import android.annotation.SuppressLint
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.android.ecommerce.typeconverters.CategoryListTypeConverter
import com.example.android.ecommerce.typeconverters.ProductListTypeConverter
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@SuppressLint("ParcelCreator")
@Parcelize
data class Category(
    @TypeConverters(CategoryListTypeConverter::class)
    @SerializedName("child_categories")
    var childCategories: MutableList<Category?>? = null,
    @SerializedName("id")
    @PrimaryKey (autoGenerate = true)
    var id: Long = 0, // 13
    @SerializedName("name")
    var name: String? = null, // Laptops
    @TypeConverters(ProductListTypeConverter::class)
    @SerializedName("products")
    var products: MutableList<Product?>? = null
) : Parcelable