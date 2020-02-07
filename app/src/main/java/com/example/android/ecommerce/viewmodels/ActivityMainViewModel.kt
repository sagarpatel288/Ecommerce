package com.example.android.ecommerce.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.android.ecommerce.base.BaseViewModel
import com.example.android.ecommerce.model.Category
import com.example.android.ecommerce.repository.Repository
import org.koin.core.KoinComponent
import org.koin.core.inject

class ActivityMainViewModel : BaseViewModel(), KoinComponent {
    private val repository : Repository by inject()
    val superParentCategoryList = MutableLiveData<List<Category>>()

    fun getParentCategories(context: Context): MutableLiveData<List<Category>>{
        val superParents = repository.getParentCategories(context)
        superParentCategoryList.value = superParents
        return superParentCategoryList
    }

    fun getCategoriesByIds(idList: ArrayList<Long>): List<Category>{
        return repository.getCategoriesByIds(idList)
    }
}