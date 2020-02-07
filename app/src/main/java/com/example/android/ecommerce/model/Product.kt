package com.example.android.ecommerce.model

import android.annotation.SuppressLint
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.android.ecommerce.typeconverters.TaxTypeConverter
import com.example.android.ecommerce.typeconverters.VariantListTypeConverter
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@SuppressLint("ParcelCreator")
@Parcelize
data class Product(@SerializedName("date_added")
                        var dateAdded: String = "",
                   @SerializedName("name")
                        var name: String = "",
                   @TypeConverters(TaxTypeConverter::class)
                   @SerializedName("tax")
                        var tax: Tax,
                   @SerializedName("id")
                   @PrimaryKey(autoGenerate = true)
                        var id: Long = 0,
                   @TypeConverters(VariantListTypeConverter::class)
                   @SerializedName("variants")
                        var variants: MutableList<Variant>?,
                   @SerializedName("view_count")
                        var viewCount: String? = "",
                   @SerializedName("order_count")
                        var orderCount: String? = "",
                   @SerializedName("shares")
                        var shares: String? = ""
                        ) : Parcelable
