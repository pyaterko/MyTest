package com.owl_laugh_at_wasted_time.mytest.di

import android.content.Context
import com.owl_laugh_at_wasted_time.mytest.presentation.activity.MainActivity
import com.owl_laugh_at_wasted_time.mytest.presentation.fragments.MainFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RepositoryModule::class,
        ApiModule::class,
        ViewModelModule::class,
        DataModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance applicationContext: Context
        ): AppComponent
    }

    fun context(): Context
    fun inject(activity: MainActivity)
    fun inject(activity: MainFragment)

}