package com.owl_laugh_at_wasted_time.mytest.di

import androidx.lifecycle.ViewModel
import com.owl_laugh_at_wasted_time.mytest.presentation.fragments.MainFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainFragmentViewModel::class)
    fun bindDictionaryViewModel(viewModel: MainFragmentViewModel): ViewModel

}