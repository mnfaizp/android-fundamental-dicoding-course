package com.example.fundamental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fundamental.databinding.ActivityBackgroundThreadBinding

class BackgroundThreadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBackgroundThreadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBackgroundThreadBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}