package com.example.android.ecommerce.typeconverters

import androidx.room.TypeConverter
import com.example.android.ecommerce.model.Variant
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class VariantListTypeConverter {
    val gson = Gson()

    @TypeConverter
    fun stringToVariantList(data: String?): MutableList<Variant?>? {
        if (data == null) {
            return null //Because we want to check in query! Collections.emptyList()
        }
        val listType: Type =
            object : TypeToken<List<Variant?>?>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun productListToString(someObjects: List<Variant?>?): String? {
        return gson.toJson(someObjects)
    }
}