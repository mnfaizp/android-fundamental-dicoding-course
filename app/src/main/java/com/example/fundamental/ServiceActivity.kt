package com.example.fundamental

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import com.example.fundamental.databinding.ActivityServiceBinding

class ServiceActivity : AppCompatActivity() {

    private var mServiceBound = false
    private lateinit var binding: ActivityServiceBinding
    private lateinit var mBoundService: BoundService

    private val mServiceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            mServiceBound = false
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val myBinder = service as BoundService.MyBinder
            mBoundService = myBinder.getService
            mServiceBound = true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            btnStartService.setOnClickListener {
                val mStartServiceIntent = Intent(this@ServiceActivity, MyService::class.java)
                startService(mStartServiceIntent)
            }

            btnIntentService.setOnClickListener {
                val mStartIntentService = Intent(this@ServiceActivity, MyIntentService::class.java)
                mStartIntentService.putExtra(MyIntentService.EXTRA_DURATION, 5000L)
                MyIntentService.enqueueWork(this@ServiceActivity, mStartIntentService)
            }

            btnStartBound.setOnClickListener {
                val mBoundServiceIntent = Intent(this@ServiceActivity, BoundService::class.java)
                bindService(mBoundServiceIntent, mServiceConnection, BIND_AUTO_CREATE)
            }

            btnStopBound.setOnClickListener {
                unbindService(mServiceConnection)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mServiceBound) {
            unbindService(mServiceConnection)
        }
    }
}