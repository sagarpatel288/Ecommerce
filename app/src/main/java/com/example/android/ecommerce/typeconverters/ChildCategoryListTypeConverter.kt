package com.example.android.ecommerce.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class ChildCategoryListTypeConverter {

    val gson = Gson()

    @TypeConverter
    fun stringToChildCategoryList(data: String?): MutableList<Long?>? {
        if (data == null) {
            return null //Because we want to check in query! Collections.emptyList()
        }
        val listType: Type =
            object : TypeToken<List<Long?>?>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun childCategoryListToString(someObjects: List<Long?>?): String? {
        return gson.toJson(someObjects)
    }
}