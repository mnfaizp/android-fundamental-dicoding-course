package com.example.fundamental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fundamental.databinding.ActivityServiceBinding

class ServiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            btnStartService.setOnClickListener {
                val mStartServiceIntent = Intent(this@ServiceActivity, MyService::class.java)
                startService(mStartServiceIntent)
            }
        }
    }
}