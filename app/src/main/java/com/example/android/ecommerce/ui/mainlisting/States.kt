package com.example.android.ecommerce.ui.mainlisting

sealed class States {
    data class SortByState(val sortByState: String): States()
}