package com.example.android.ecommerce.repository

import android.content.Context
import com.example.android.ecommerce.apputils.AppUtils
import com.example.android.ecommerce.model.*
import com.example.android.ecommerce.utils.FileUtils
import com.example.android.ecommerce.utils.Utils
import com.example.android.kotlin_mvvm_room_koin_coroutine.db.dao.CategoryDao
import com.example.android.kotlin_mvvm_room_koin_coroutine.db.dao.ProductDao
import com.example.android.kotlin_mvvm_room_koin_coroutine.db.dao.RankingDao
import org.koin.core.KoinComponent
import org.koin.core.get
import org.koin.core.inject
import java.util.*
import kotlin.collections.ArrayList

class Repository : KoinComponent {
    private val categoryDao: CategoryDao by inject()
    private val productDao: ProductDao by inject()
    private val rankingDao: RankingDao by inject()

    fun insertCategories(categoryList: ArrayList<Category>) {
        categoryDao.insertList(categoryList)
    }

    fun getParentCategories(context: Context): List<Category> {
        if (!AppUtils.hasCategory(get())) {
            val jsonString: String = FileUtils.getJsonFromAsset(context, "ecommerce.json")
            val response: Response = Utils.toObject(jsonString, Response(), Response::class.java)
            val categoryList: List<Category?>? = response.categories
            val rankingList: List<Ranking?>? = response.rankings
            categoryDao.insertList(categoryList)
            rankingDao.insertList(rankingList)
            val productList: ArrayList<Product?>? = ArrayList<Product?>()

            categoryList?.forEach { category ->
                category?.products?.let { products ->

                    products.forEach { product ->
                        product?.parentId = category.id
                    }

                    productList?.addAll(products)
                }
            }

            productDao.insertList(productList)
        }

        // comment by srdpatel: 2/7/2020 Null cannot be cast to Non-Null
        val parentCategoryList: List<Category>? =
            categoryDao.getParentCategories()

        val parentIds: ArrayList<Long>? =
            parentCategoryList?.map { it.id }?.toMutableList() as ArrayList<Long>?

        val childrenIds = arrayListOf<Long>()

        /*https://stackoverflow.com/questions/44595529/smart-cast-to-type-is-impossible-because-variable-is-a-mutable-property-tha*/
        parentCategoryList?.forEach { category ->
            category.childCategories?.let { children -> childrenIds.addAll(children) }
        }

        parentIds?.removeAll(childrenIds)

        return getCategoriesByIds(parentIds!!)
    }

    fun getIdsFromCategoryList(categoryList: ArrayList<Category>): ArrayList<Long>? {
        return categoryList.map { it.id }.toMutableList() as ArrayList<Long>
    }

    fun getCategoriesByIds(idList: List<Long>): List<Category> {
        return categoryDao.getCategoryListByIds(idList)
    }

    fun getCategoryById(id: Long): Category? {
        return categoryDao.getCategoryById(id)
    }

    fun getProductsByParentId(parentId: Long): List<Product?>? {
        return productDao.getProductsByParentId(parentId)
    }

    fun getSortByOptionList(): List<SortBy> {
        val rankingList = rankingDao.getAllRankings()
        val sortByOptionList = ArrayList<SortBy>()
        rankingList.forEach { element -> sortByOptionList.add(SortBy(element.ranking ?: "")) }
        sortByOptionList.add(0, SortBy("Category"))
        return sortByOptionList
    }

    fun getProductListByViews(): List<Product>? {
        val rankingList = rankingDao.getAllRankings()
        rankingList.forEach { rank ->
            if (rank.ranking?.toLowerCase(Locale.getDefault())?.contains("view") == true) {
                return rank.products
            }
        }
        return null
    }

    fun getProductListByOrder(): List<Product>? {
        val rankingList = rankingDao.getAllRankings()
        rankingList.forEach { rank ->
            if (rank.ranking?.toLowerCase(Locale.getDefault())?.contains("order") == true) {
                return rank.products
            }
        }
        return null
    }

    fun getProductListBySharings(): List<Product>? {
        val rankingList = rankingDao.getAllRankings()
        rankingList.forEach { rank ->
            if (rank.ranking?.toLowerCase(Locale.getDefault())?.contains("share") == true) {
                return rank.products
            }
        }
        return null
    }
}

