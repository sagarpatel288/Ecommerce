package com.example.android.ecommerce.listeners

import android.content.Intent

abstract class Callbacks {

    interface Callback {
        fun onEventCallBack(intent: Intent)
    }
}