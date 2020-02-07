package com.example.android.ecommerce.typeconverters

import androidx.room.TypeConverter
import com.example.android.ecommerce.utils.StringUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class ChildCategoryListTypeConverter {

    val gson = Gson()

    @TypeConverter
    fun stringToChildCategoryList(data: String?): List<Long?>? {
        if (StringUtils.isNullOrEmpty(data)) {
            return null //Because we want to check in query! Collections.emptyList()
        }
        val listType: Type =
            object : TypeToken<List<Long?>?>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun childCategoryListToString(childCategoryList: List<Long?>?): String? {
        if (childCategoryList.isNullOrEmpty()){
            return null
        }
        return gson.toJson(childCategoryList)
    }
}