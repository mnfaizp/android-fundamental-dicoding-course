package com.example.fundamental

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.CountDownTimer
import android.os.IBinder
import android.util.Log

class BoundService : Service() {

    companion object {
        private val TAG = BoundService::class.java.simpleName
    }

    private var mBinder = MyBinder()
    private val startTime = System.currentTimeMillis()

    inner class MyBinder : Binder() {
        val getService: BoundService = this@BoundService
    }

    private var mTimer: CountDownTimer = object : CountDownTimer(100000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            val elapsedTime = System.currentTimeMillis() - startTime
            Log.d(TAG, "onTick: $elapsedTime")
        }

        override fun onFinish() {

        }
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: ")
    }

    override fun onBind(intent: Intent): IBinder {
        Log.d(TAG, "onBind()")
        mTimer.start()
        return mBinder
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(TAG, "onUnbind: ")
        mTimer.cancel()
        return super.onUnbind(intent)
    }

    override fun onRebind(intent: Intent?) {
        Log.d(TAG, "onRebind: ")
        super.onRebind(intent)
    }
}