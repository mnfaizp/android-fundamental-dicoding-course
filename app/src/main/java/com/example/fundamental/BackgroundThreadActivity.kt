package com.example.fundamental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.fundamental.databinding.ActivityBackgroundThreadBinding
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class BackgroundThreadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBackgroundThreadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBackgroundThreadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())

        binding.btnStart.setOnClickListener {
            executor.execute {
                try {
                    for (i in 0..10) {
                        Thread.sleep(500)
                        val percentage = i * 10

                        handler.post {
                            if (percentage == 100) {
                                binding.tvStatus.setText(R.string.task_completed)
                            } else {
                                binding.tvStatus.text =
                                    String.format(getString(R.string.compressing), percentage)
                            }
                        }
                    }
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
    }
}