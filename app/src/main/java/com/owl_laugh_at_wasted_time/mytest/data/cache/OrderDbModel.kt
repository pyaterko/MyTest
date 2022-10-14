package com.owl_laugh_at_wasted_time.mytest.data.cache

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_table")
data class OrderDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val foodImage:String,
    val orderName:String,
    val discription:String,
    val price:String
)
