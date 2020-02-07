package com.example.android.kotlin_mvvm_room_koin_coroutine.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.android.ecommerce.model.Category
import com.example.android.ecommerce.model.Product
import com.example.android.ecommerce.model.Ranking
import com.example.android.ecommerce.typeconverters.*
import com.example.android.kotlin_mvvm_room_koin_coroutine.db.dao.CategoryDao
import com.example.android.kotlin_mvvm_room_koin_coroutine.db.dao.ProductDao
import com.example.android.kotlin_mvvm_room_koin_coroutine.db.dao.RankingDao

@Database(
    entities = [(Category::class), (Product::class), (Ranking::class)],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    CategoryListTypeConverter::class,
    ProductListTypeConverter::class,
    TaxListTypeConverter::class,
    VariantListTypeConverter::class,
    TaxTypeConverter::class,
    VariantTypeConverter::class,
    ChildCategoryListTypeConverter::class
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getCategoryDao(): CategoryDao
    abstract fun getProductDao(): ProductDao
    abstract fun getRankingDao(): RankingDao
}