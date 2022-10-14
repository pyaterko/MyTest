package com.owl_laugh_at_wasted_time.mytest.data.cache

import androidx.lifecycle.LiveData
import androidx.room.*
import com.owl_laugh_at_wasted_time.mytest.domain.entity.Order

@Dao
interface FoodDao {

    @Query("SELECT * FROM food_table")
     fun getAllData(): LiveData<List<OrderDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addItem(item: OrderDbModel)

    @Query("DELETE FROM food_table")
    suspend fun deleteAll()

}