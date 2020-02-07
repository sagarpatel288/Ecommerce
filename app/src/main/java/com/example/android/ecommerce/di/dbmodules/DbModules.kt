package com.example.android.ecommerce.di.dbmodules

import androidx.room.Room
import com.example.android.ecommerce.repository.Repository
import com.example.android.kotlin_mvvm_room_koin_coroutine.db.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dbModule = module {
    single {
        Room
            .databaseBuilder(
                androidApplication(),
                AppDatabase::class.java,
                "myApp.db"
            )
            .allowMainThreadQueries()
            .build()
    }

    single {
        get<AppDatabase>().getCategoryDao()
    }

    single {
        get<AppDatabase>().getProductDao()
    }

    single {
        get<AppDatabase>().getRankingDao()
    }

    single {
        Repository(androidApplication())
    }
}