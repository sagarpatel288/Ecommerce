package com.example.android.kotlin_mvvm_room_koin_coroutine.db.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ProductDao : BaseDao<ProductDao> {

    @Query("select * from Category")
    fun getAllCategories(): List<ProductDao>?

    @Query("delete from Category")
    fun deleteAllCategories()

    @Query("select * from Category where id =:id")
    fun getCategoryById(id: Long): ProductDao?
}