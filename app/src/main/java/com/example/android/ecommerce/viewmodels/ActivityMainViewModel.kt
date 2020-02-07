package com.example.android.ecommerce.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.android.ecommerce.base.BaseViewModel
import com.example.android.ecommerce.model.Category
import com.example.android.ecommerce.repository.Repository
import org.koin.core.KoinComponent
import org.koin.core.inject

class ActivityMainViewModel : BaseViewModel(), KoinComponent {
    private val repository : Repository by inject()

    fun getParentCategories(context: Context): LiveData<List<Category>?>?{
        return repository.getParentCategories(context)
    }
}