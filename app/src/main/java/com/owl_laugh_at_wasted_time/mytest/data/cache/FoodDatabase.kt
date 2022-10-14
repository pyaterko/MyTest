package com.owl_laugh_at_wasted_time.mytest.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [OrderDbModel::class], version = 1, exportSchema = false)
abstract class FoodDatabase : RoomDatabase() {

    abstract fun foodDao(): FoodDao
}