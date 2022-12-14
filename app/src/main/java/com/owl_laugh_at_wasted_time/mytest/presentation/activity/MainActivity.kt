package com.owl_laugh_at_wasted_time.mytest.presentation.activity

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.owl_laugh_at_wasted_time.mytest.Initializer
import com.owl_laugh_at_wasted_time.mytest.databinding.ActivityMainBinding
import com.owl_laugh_at_wasted_time.mytest.presentation.base.viewBinding


class MainActivity : AppCompatActivity() {

    private  val binding by viewBinding (ActivityMainBinding::inflate)

    val component by lazy {
        Initializer.component(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

}