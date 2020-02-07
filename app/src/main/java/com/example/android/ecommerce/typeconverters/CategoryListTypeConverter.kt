package com.example.android.ecommerce.typeconverters

import androidx.room.TypeConverter
import com.example.android.ecommerce.model.Category
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class CategoryListTypeConverter {

    val gson = Gson()

    @TypeConverter
    fun stringToCategoryList(data: String?): MutableList<Category?>? {
        if (data == null) {
            return null //Because we want to check in query! Collections.emptyList()
        }
        val listType: Type =
            object : TypeToken<List<Category?>?>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun productListToString(someObjects: List<Category?>?): String? {
        return gson.toJson(someObjects)
    }
}