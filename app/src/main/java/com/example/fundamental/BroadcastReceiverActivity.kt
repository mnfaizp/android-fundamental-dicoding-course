package com.example.fundamental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.fundamental.databinding.ActivityBroadcastReceiverBinding

class BroadcastReceiverActivity : AppCompatActivity(), View.OnClickListener {

    private var binding: ActivityBroadcastReceiverBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBroadcastReceiverBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnCheckSms?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {

        }
    }

    override fun onDestroy() {
        super.onDestroy()

        binding = null
    }
}