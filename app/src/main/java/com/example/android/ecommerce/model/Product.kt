package com.example.android.ecommerce.model

import android.annotation.SuppressLint
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class Product(@SerializedName("date_added")
                        var dateAdded: String = "",
                   @SerializedName("name")
                        var name: String = "",
                   @SerializedName("tax")
                        var tax: Tax,
                   @SerializedName("id")
                        var id: Long = 0,
                   @SerializedName("variants")
                        var variants: List<Variant>?,
                   @SerializedName("view_count")
                        var viewCount: String? = "",
                   @SerializedName("order_count")
                        var orderCount: String? = "",
                   @SerializedName("shares")
                        var shares: String? = ""
                        ) : Parcelable
