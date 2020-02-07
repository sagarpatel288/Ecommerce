package com.example.android.ecommerce.typeconverters

import androidx.room.TypeConverter
import com.example.android.ecommerce.model.Variant
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class VariantTypeConverter {
    val gson = Gson()

    @TypeConverter
    fun stringToVariant(data: String?): Variant? {
        if (data == null) {
            return null //Because we want to check in query! Collections.emptyList()
        }
        val variantType: Type =
            object : TypeToken<Variant>() {}.type
        return gson.fromJson(data, variantType)
    }

    @TypeConverter
    fun variantToString(someObject: Variant?): String? {
        return gson.toJson(someObject)
    }
}