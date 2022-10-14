package com.owl_laugh_at_wasted_time.mytest.di

import android.content.Context
import androidx.room.Room
import com.owl_laugh_at_wasted_time.mytest.data.cache.FoodDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface DataModule {

    companion object {

        @Singleton
        @Provides
        fun provideFoodDao(
            context: Context
        ) = Room.databaseBuilder(
            context,
            FoodDatabase::class.java,
            "food_data_base"
        )
            .fallbackToDestructiveMigration()
            .build()
            .foodDao()
    }


}