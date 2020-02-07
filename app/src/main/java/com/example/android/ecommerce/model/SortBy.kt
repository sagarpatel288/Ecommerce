package com.example.android.ecommerce.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SortBy(
    var name: String?
) : Parcelable