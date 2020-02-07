package com.example.android.ecommerce.viewmodels

import androidx.lifecycle.MutableLiveData
import com.example.android.ecommerce.base.BaseViewModel
import com.example.android.ecommerce.model.Category
import com.example.android.ecommerce.repository.Repository
import org.koin.core.KoinComponent
import org.koin.core.inject

class ActivityDetailViewModel : BaseViewModel(), KoinComponent {
    private val repository: Repository by inject()
    val category = MutableLiveData<Category>()

    fun getParentCategory(parentId: Long): MutableLiveData<Category> {
        val categoryFromId = repository.getCategoryById(parentId)
        category.value = categoryFromId
        return category
    }
}