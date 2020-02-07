package com.example.android.ecommerce.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Detail(
  var category: Category?,
  var product: Product?,
  var variant: Variant?
) : Parcelable