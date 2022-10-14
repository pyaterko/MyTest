package com.owl_laugh_at_wasted_time.mytest.di

import com.owl_laugh_at_wasted_time.mytest.data.FoodRepositoryImpl
import com.owl_laugh_at_wasted_time.mytest.data.remote.DefaultApiWorker
import com.owl_laugh_at_wasted_time.mytest.data.remote.FoodApiWorker
import com.owl_laugh_at_wasted_time.mytest.domain.repositorys.FoodRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Singleton
    @Binds
    fun bindRepository(impl: FoodRepositoryImpl): FoodRepository

    @Singleton
    @Binds
    fun bindFoodApiWorker(impl: DefaultApiWorker): FoodApiWorker

}