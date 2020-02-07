package com.example.android.ecommerce.apputils

import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.example.android.ecommerce.model.Product
import com.example.android.kotlin_mvvm_room_koin_coroutine.db.dao.CategoryDao
import com.example.android.kotlin_mvvm_room_koin_coroutine.db.dao.ProductDao

class AppUtils {
    companion object {
        fun hasCategory(categoryDao: CategoryDao): Boolean {
            return categoryDao.getCheckHasCategory() != null
        }

        fun getProductsOrderBy(productDao: ProductDao, column: String): List<Product?>? {
            val statement = "SELECT * FROM Product ORDER BY $column ASC"
            val query: SupportSQLiteQuery = SimpleSQLiteQuery(statement, arrayOf())
            return productDao.getProductsOrderBy(query)
        }
    }
}