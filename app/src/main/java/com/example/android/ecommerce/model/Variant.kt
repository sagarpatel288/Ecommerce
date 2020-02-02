package com.example.android.ecommerce.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Variant(@SerializedName("color")
                        var color: String = "",
                   @SerializedName("size")
                        var size: Int = 0,
                   @SerializedName("price")
                        var price: Int = 0,
                   @SerializedName("id")
                        var id: Int = 0) : Parcelable