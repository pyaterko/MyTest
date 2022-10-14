package com.owl_laugh_at_wasted_time.mytest.presintation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.owl_laugh_at_wasted_time.mytest.presintation.base.viewBinding
import com.owl_laugh_at_wasted_time.mytest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  val binding by viewBinding (ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}