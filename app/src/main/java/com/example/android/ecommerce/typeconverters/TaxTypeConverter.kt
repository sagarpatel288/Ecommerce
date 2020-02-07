package com.example.android.ecommerce.typeconverters

import androidx.room.TypeConverter
import com.example.android.ecommerce.model.Tax
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class TaxTypeConverter {
    val gson = Gson()

    @TypeConverter
    fun stringToTax(data: String?): Tax? {
        if (data == null) {
            return null //Because we want to check in query!
        }
        val taxType: Type =
            object : TypeToken<Tax>() {}.type
        return gson.fromJson(data, taxType)
    }

    @TypeConverter
    fun taxToString(someObject: Tax): String? {
        return gson.toJson(someObject)
    }
}