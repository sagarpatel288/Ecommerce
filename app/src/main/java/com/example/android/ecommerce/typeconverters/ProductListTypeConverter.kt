package com.example.android.ecommerce.typeconverters

import androidx.room.TypeConverter
import com.example.android.ecommerce.model.Product
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class ProductListTypeConverter {

    val gson = Gson()

    @TypeConverter
    fun stringToProductList(data: String?): List<Product?>? {
        if (data == null) {
            return null //Because we want to check in query! Collections.emptyList()
        }
        val listType: Type =
            object : TypeToken<List<Product?>?>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun productListToString(someObjects: List<Product?>?): String? {
        return gson.toJson(someObjects)
    }
}