package com.example.android.kotlin_mvvm_room_koin_coroutine.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.android.ecommerce.model.Category

@Dao
interface CategoryDao : BaseDao<Category> {

    @Query("select * from Category")
    fun getAllCategories(): LiveData<List<Category?>>?

    @Query("select * from Category limit 1")
    fun getCheckHasCategory(): Category?

    @Query("select * from Category where childCategories is not null")
    fun getParentCategories(): LiveData<List<Category>?>?

    @Query("delete from Category")
    fun deleteAllCategories()

    @Query("select * from Category where id =:id")
    fun getCategoryById(id: Long): LiveData<Category>?
}