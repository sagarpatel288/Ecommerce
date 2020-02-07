package com.example.android.ecommerce.repository

import com.example.android.ecommerce.model.Category
import com.example.android.kotlin_mvvm_room_koin_coroutine.db.dao.CategoryDao
import com.example.android.kotlin_mvvm_room_koin_coroutine.db.dao.ProductDao
import com.example.android.kotlin_mvvm_room_koin_coroutine.db.dao.RankingDao
import org.koin.core.KoinComponent
import org.koin.core.inject

class Repository : KoinComponent {
    private val categoryDao: CategoryDao by inject()
    private val productDao: ProductDao by inject()
    private val rankingDao: RankingDao by inject()

    fun insertCategories(categoryList: MutableList<Category>) {
        categoryDao.insertList(categoryList)
    }

    fun getParentCategories(): MutableList<Category?>?{
        return categoryDao.getParentCategories()
    }
}