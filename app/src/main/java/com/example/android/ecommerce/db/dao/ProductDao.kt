package com.example.android.kotlin_mvvm_room_koin_coroutine.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.RawQuery
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.example.android.ecommerce.model.Product


@Dao
interface ProductDao : BaseDao<ProductDao> {

    @Query("select * from Product")
    fun getAllProducts(): MutableList<Product?>?

    @Query("delete from Product")
    fun deleteAllProducts()

    @Query("select * from Product where id =:id")
    fun getProductById(id: Long): Product?

    @RawQuery
    fun getProductsOrderBy(query: SupportSQLiteQuery): MutableList<Product?>?

    fun getProductsOrderBy(column: String): List<Product?>? {
        val statement = "SELECT * FROM Product ORDER BY $column ASC"
        val query: SupportSQLiteQuery = SimpleSQLiteQuery(statement, arrayOf())
        return getProductsOrderBy(query)
    }
}