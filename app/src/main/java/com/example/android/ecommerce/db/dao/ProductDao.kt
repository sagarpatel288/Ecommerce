package com.example.android.kotlin_mvvm_room_koin_coroutine.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.RawQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.example.android.ecommerce.model.Product


@Dao
interface ProductDao : BaseDao<Product> {

    @Query("select * from Product")
    fun getAllProducts(): List<Product>

    @Query("delete from Product")
    fun deleteAllProducts()

    @Query("select * from Product where id =:id")
    fun getProductById(id: Long): Product

    @Query("select * from Product where id IN(:ids)")
    fun getProductListByIds(ids: List<Long>): List<Product>

    @RawQuery
    fun getProductsOrderBy(query: SupportSQLiteQuery): List<Product>

    @Query("SELECT * FROM Product WHERE parentId=:parentId")
    fun getProductsByParentId(parentId: Long): List<Product?>?
}