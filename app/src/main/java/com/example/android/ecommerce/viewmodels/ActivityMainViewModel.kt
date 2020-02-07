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
import java.util.*

class ActivityMainViewModel : BaseViewModel(), KoinComponent {
    private val repository: Repository by inject()
    val superParentCategoryList = MutableLiveData<List<Category>>()
    val productList = MutableLiveData<List<Product>>()
    val sortBy = MutableLiveData<SortBy>()

    fun getSortByOption(): MutableLiveData<SortBy> {
        if (sortBy.value?.name.isNullOrEmpty()){
            val sortByOption = SortBy("Category")
            sortBy.value = sortByOption
        }
        return sortBy
    }

    fun getParentCategories(context: Context): MutableLiveData<List<Category>> {
        val superParents = repository.getParentCategories(context)
        superParentCategoryList.value = superParents
        return superParentCategoryList
    }

    fun getProductList(context: Context): MutableLiveData<List<Product>> {
        return productList
    }

    fun getCategoriesByIds(idList: List<Long>): List<Category> {
        return repository.getCategoriesByIds(idList)
    }

    fun getProductsByParentId(parentId: Long): List<Product?>? {
        return repository.getProductsByParentId(parentId)
    }

    fun getSortByOptionList(): List<SortBy> {
        return repository.getSortByOptionList()
    }

    fun sortByViewed(sortBy: SortBy): MutableLiveData<List<Product>> {
        val products = repository.getProductListByViews()
        productList.value = products
        if (!this.sortBy.value?.name.toString().toLowerCase().contains("viewed")){
            this.sortBy.value = sortBy
        }
        return productList
    }

    fun sortByOrdered(sortBy: SortBy): MutableLiveData<List<Product>> {
        val products = repository.getProductListByOrder()
        productList.value = products
        if (!this.sortBy.value?.name.toString().toLowerCase().contains("ordered")){
            this.sortBy.value = sortBy
        }
        return productList
    }

    fun sortByShared(sortBy: SortBy): MutableLiveData<List<Product>> {
        val products = repository.getProductListBySharings()
        productList.value = products
        if (!this.sortBy.value?.name.toString().toLowerCase().contains("shared")){
            this.sortBy.value = sortBy
        }
        return productList
    }

    fun sortByCategory(
        context: Context,
        sortBy: SortBy
    ): MutableLiveData<List<Category>> {
        val superParents = repository.getParentCategories(context)
        superParentCategoryList.value = superParents
        if (!this.sortBy.value?.name.toString().toLowerCase().contains("category")){
            this.sortBy.value = sortBy
        }
        return superParentCategoryList
    }

    fun setSortBy(context: Context, sortBy: SortBy) {
        if (sortBy.name?.toLowerCase(Locale.getDefault())?.contains("viewed") == true) {
            sortByViewed(sortBy)
        } else if (sortBy.name?.toLowerCase(Locale.getDefault())?.contains("ordered") == true) {
            sortByOrdered(sortBy)
        } else if (sortBy.name?.toLowerCase(Locale.getDefault())?.contains("shared") == true) {
            sortByShared(sortBy)
        } else if (sortBy.name?.toLowerCase(Locale.getDefault())?.contains("category") == true) {
            sortByCategory(context, sortBy)
        }
    }
}