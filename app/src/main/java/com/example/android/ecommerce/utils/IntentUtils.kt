package com.example.android.ecommerce.utils

import android.content.Intent
import android.os.Parcelable
import com.example.android.ecommerce.constants.PARCEL

class IntentUtils {
    companion object {

        @JvmStatic
        fun hasParcel(intent: Intent): Boolean {
            return intent.hasExtra(PARCEL)
        }

        @JvmStatic
        fun<T: Parcelable> getParcel(intent: Intent): T? {
            return if (hasParcel(intent)) intent.getParcelableExtra(PARCEL) else null
        }
    }
}