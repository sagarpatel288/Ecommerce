package com.example.android.kotlin_mvvm_room_koin_coroutine.db.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface CategoryDao : BaseDao<CategoryDao> {

    @Query("select * from Category")
    fun getAllCategories(): List<CategoryDao>?

    @Query("delete from Category")
    fun deleteAllCategories()

    @Query("select * from Category where id =:id")
    fun getCategoryById(id: Long): CategoryDao?
}