package com.example.android.ecommerce.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.android.ecommerce.base.BaseViewModel
import com.example.android.ecommerce.model.Category
import com.example.android.ecommerce.model.Product
import com.example.android.ecommerce.model.SortBy
import com.example.android.ecommerce.repository.Repository
import org.koin.core.KoinComponent
import org.koin.core.inject

class ActivityMainViewModel : BaseViewModel(), KoinComponent {
    private val repository : Repository by inject()
    val superParentCategoryList = MutableLiveData<List<Category>>()
    val productList = MutableLiveData<List<Product>>()

    fun getParentCategories(context: Context): MutableLiveData<List<Category>>{
        val superParents = repository.getParentCategories(context)
        superParentCategoryList.value = superParents
        return superParentCategoryList
    }

    fun getProductList(context: Context): MutableLiveData<List<Product>>{
        return productList
    }

    fun getCategoriesByIds(idList: List<Long>): List<Category>{
        return repository.getCategoriesByIds(idList)
    }

    fun getProductsByParentId(parentId: Long): List<Product?>?{
        return repository.getProductsByParentId(parentId)
    }

    fun getSortByOptionList(): List<SortBy>{
        return repository.getSortByOptionList()
    }

    fun sortByViewed(context: Context): MutableLiveData<List<Product>> {
        val products = repository.getProductListByViews()
//        superParentCategoryList.value = null
        productList.value = products
        return productList
    }

    fun sortByOrdered(context: Context): MutableLiveData<List<Product>> {
        val products = repository.getProductListByOrder()
        productList.value = products
//        superParentCategoryList.value = null
        return productList
    }

    fun sortByShared(context: Context): MutableLiveData<List<Product>> {
        val products = repository.getProductListBySharings()
        productList.value = products
//        superParentCategoryList.value = null
        return productList
    }

    fun sortByCategory(context: Context) {
        val superParents = repository.getParentCategories(context)
        superParentCategoryList.value = superParents
//        productList.value = null
    }
}