package com.owl_laugh_at_wasted_time.mytest

import android.content.Context
import com.owl_laugh_at_wasted_time.mytest.di.AppComponent
import com.owl_laugh_at_wasted_time.mytest.di.DaggerAppComponent


object Initializer {
    fun component(context: Context): AppComponent {
        return DaggerAppComponent.factory().create(context)
    }
}