package com.example.android.ecommerce.typeconverters

import androidx.room.TypeConverter
import com.example.android.ecommerce.model.Tax
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class TaxListTypeConverter {
    val gson = Gson()

    @TypeConverter
    fun stringToTaxList(data: String?): MutableList<Tax?>? {
        if (data == null) {
            return null //Because we want to check in query! Collections.emptyList()
        }
        val listType: Type =
            object : TypeToken<List<Tax?>?>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun productListToString(someObjects: List<Tax?>?): String? {
        return gson.toJson(someObjects)
    }
}