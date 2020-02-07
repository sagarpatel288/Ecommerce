package com.example.android.ecommerce.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.android.ecommerce.model.Category
import com.example.android.ecommerce.model.Ranking
import com.example.android.ecommerce.model.Response
import com.example.android.ecommerce.utils.FileUtils
import com.example.android.ecommerce.utils.Utils
import com.example.android.kotlin_mvvm_room_koin_coroutine.db.dao.CategoryDao
import com.example.android.kotlin_mvvm_room_koin_coroutine.db.dao.ProductDao
import com.example.android.kotlin_mvvm_room_koin_coroutine.db.dao.RankingDao
import org.koin.core.KoinComponent
import org.koin.core.inject

class Repository: KoinComponent {
    private val categoryDao: CategoryDao by inject()
    private val productDao: ProductDao by inject()
    private val rankingDao: RankingDao by inject()

    fun insertCategories(categoryList: ArrayList<Category>) {
        categoryDao.insertList(categoryList)
    }

    fun getParentCategories(context: Context): MutableLiveData<ArrayList<Category>?>?{
        if (!categoryDao.hasCategory()){
            val jsonString: String = FileUtils.getJsonFromAsset(context, "ecommerce.json")
            val response : Response = Utils.toObject(jsonString, Response(), Response::class.java)
            val categoryList: List<Category?>? = response.categories
            val rankingList: List<Ranking?>? = response.rankings
            categoryDao.insertList(categoryList)
            rankingDao.insertList(rankingList)
        }
        return categoryDao.getParentCategories()
    }
}