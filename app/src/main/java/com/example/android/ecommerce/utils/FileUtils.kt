package com.example.android.ecommerce.utils

import android.content.Context
import android.util.Log
import java.io.IOException

class FileUtils {
    companion object {
        @JvmStatic
        fun getJsonFromAsset(context: Context, jsonFileNameWithExtension: String) : String? {
            var jsonString : String = ""
            // comment by srdpatel: 2/4/2020  https://www.myandroidsolutions.com/2019/07/25/android-parse-json-file-from-assets/#.XjlT6WgzbDc
            try {
                val inputStream = context.getAssets().open(jsonFileNameWithExtension)
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.use { it.read(buffer) }
                jsonString = String(buffer)
            } catch (ioException: IOException) {
                ioException.printStackTrace()
                return jsonString
            }
            // print the data
            Log.i("json: ", jsonString)
            return jsonString
        }
    }
}