package com.example.android.kotlin_mvvm_room_koin_coroutine.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.android.ecommerce.model.Category

@Dao
interface CategoryDao : BaseDao<Category> {

    @Query("select * from Category")
    fun getAllCategories(): List<Category>

    @Query("select * from Category limit 1")
    fun getCheckHasCategory(): Category?

    @Query("select * from Category where childCategories is not null")
    fun getParentCategories(): List<Category>

    @Query("delete from Category")
    fun deleteAllCategories()

    @Query("select * from Category where id =:id")
    fun getCategoryById(id: Long): LiveData<Category>?

    /*@Query("SELECT * FROM song WHERE id IN(:songIds)")
     public abstract List<Song> findByIds(long[] songIds);*/

    @Query("select * from Category where id IN(:ids)")
    fun getCategoryListByIds(ids: List<Long>): List<Category>
}