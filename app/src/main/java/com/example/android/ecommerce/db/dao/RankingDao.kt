package com.example.android.kotlin_mvvm_room_koin_coroutine.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.android.ecommerce.model.Ranking

@Dao
interface RankingDao : BaseDao<RankingDao> {

    @Query("select * from Ranking")
    fun getAllRankings(): MutableList<Ranking?>?

    @Query("delete from Ranking")
    fun deleteAllRanking()
}