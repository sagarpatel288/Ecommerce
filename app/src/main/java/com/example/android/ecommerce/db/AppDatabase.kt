package com.example.android.kotlin_mvvm_room_koin_coroutine.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android.ecommerce.model.Category
import com.example.android.ecommerce.model.Product
import com.example.android.kotlin_mvvm_room_koin_coroutine.db.dao.CategoryDao
import com.example.android.kotlin_mvvm_room_koin_coroutine.db.dao.ProductDao

@Database(entities = [(Category::class), (Product::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getCategoryDao(): CategoryDao
    abstract fun getProductDao() : ProductDao
}