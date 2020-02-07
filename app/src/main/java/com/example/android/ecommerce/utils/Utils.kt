package com.example.android.ecommerce.utils

import android.view.View
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.internal.LinkedTreeMap
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class Utils {

    companion object {

        @JvmStatic
        fun <T> toObject(jsonString: String, emptyObject: T, classOfObject: Class<T>): T {
            val newObject: T
            val gson = Gson()
            val type: Type =
                TypeToken.getParameterized(classOfObject, classOfObject).type
            gson.toJson(emptyObject, type)
            newObject = gson.fromJson(jsonString, type)
            return newObject
        }

        @JvmStatic
        fun <T> toJsonString(gsonSerializedObject: T): String {
            val gson = Gson()
            return gson.toJson(gsonSerializedObject)
        }

        @JvmStatic
        fun toJsonObject(linkedTreeMap: LinkedTreeMap<Any?, Any?>): JsonObject {
            val gson = Gson()
            return gson.toJsonTree(linkedTreeMap).asJsonObject
        }

        @JvmStatic
        fun toJsonString(jsonObject: JsonObject): String {
            val gson = Gson()
            return gson.toJson(jsonObject)
        }
    }
}