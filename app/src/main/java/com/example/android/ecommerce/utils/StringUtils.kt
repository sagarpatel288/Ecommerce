package com.example.android.ecommerce.utils

class StringUtils {
    companion object{

        @JvmStatic
        fun isNullOrEmpty(string: String?): Boolean{
            return string.isNullOrEmpty() || string.equals("null", ignoreCase = true)
        }
    }
}