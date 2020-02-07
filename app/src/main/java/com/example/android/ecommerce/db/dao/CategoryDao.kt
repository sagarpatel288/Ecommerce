package com.example.android.kotlin_mvvm_room_koin_coroutine.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.android.ecommerce.model.Category

@Dao
interface CategoryDao : BaseDao<Category> {

    @Query("select * from Category")
    fun getAllCategories(): MutableList<Category?>?

    @Query("select * from Category where childCategories is not null")
    fun getParentCategories(): MutableList<Category?>?

    @Query("delete from Category")
    fun deleteAllCategories()

    @Query("select * from Category where id =:id")
    fun getCategoryById(id: Long): Category?
}