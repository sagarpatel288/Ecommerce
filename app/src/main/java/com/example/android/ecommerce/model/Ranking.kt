package com.example.android.ecommerce.model


import android.annotation.SuppressLint
import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@SuppressLint("ParcelCreator")
@Parcelize
data class Ranking(
    @SerializedName("products")
    var products: List<Product?>? = null,
    @SerializedName("ranking")
    var ranking: String? = null // Most ShaRed Products
) : Parcelable