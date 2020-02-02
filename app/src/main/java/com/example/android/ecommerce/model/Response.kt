package com.example.android.ecommerce.model


import android.annotation.SuppressLint
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class Response(
    @SerializedName("categories")
    var categories: List<Category?>? = null,
    @SerializedName("rankings")
    var rankings: List<Ranking?>? = null
) : Parcelable