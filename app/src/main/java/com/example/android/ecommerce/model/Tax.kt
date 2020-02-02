package com.example.android.ecommerce.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Tax(@SerializedName("name")
               var name: String = "",
               @SerializedName("value")
               var value: Double = 0.0) : Parcelable