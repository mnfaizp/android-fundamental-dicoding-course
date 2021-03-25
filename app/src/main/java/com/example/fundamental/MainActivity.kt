package com.example.fundamental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnToIntent: Button = findViewById(R.id.btn_to_intent)
        btnToIntent.setOnClickListener(this)

        val btnToFragment: Button = findViewById(R.id.btn_to_fragment)
        btnToFragment.setOnClickListener(this)

        val btnToListView: Button = findViewById(R.id.btn_to_listView)
        btnToListView.setOnClickListener(this)

        val btnToCustomView: Button = findViewById(R.id.btn_to_customView)
        btnToCustomView.setOnClickListener(this)

        val btnToUnitTestingActivity: Button = findViewById(R.id.btn_to_testing)
        btnToUnitTestingActivity.setOnClickListener(this)

        val btnToBackgroundThreadActivity: Button = findViewById(R.id.btn_to_background_thread)
        btnToBackgroundThreadActivity.setOnClickListener(this)

        val btnToServiceActivity: Button = findViewById(R.id.btn_to_service)
        btnToServiceActivity.setOnClickListener(this)

        val btnToBroadcastReceiver: Button = findViewById(R.id.btn_to_broadcast_receiver)
        btnToBackgroundThreadActivity.setOnClickListener(this)

        val btnToAlarmManagerActivity: Button = findViewById(R.id.btn_to_alarm_manager)
        btnToAlarmManagerActivity.setOnClickListener(this)

        val btnToJsonActivity: Button = findViewById(R.id.btn_to_json)
        btnToJsonActivity.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_to_intent -> {
                val moveToIntentActivity = Intent(this@MainActivity, IntentActivity::class.java)
                startActivity(moveToIntentActivity)
            }

            R.id.btn_to_fragment -> {
                val moveToFragmentActivity = Intent(this, FragmentActivity::class.java)
                startActivity(moveToFragmentActivity)
            }

            R.id.btn_to_listView -> {
                val moveToListViewActivity = Intent(this, ListViewActivity::class.java)
                startActivity(moveToListViewActivity)
            }

            R.id.btn_to_customView -> {
                val moveToCustomView = Intent(this, CustomViewActivity::class.java)
                startActivity(moveToCustomView)
            }

            R.id.btn_to_testing -> {
                val mIntent = Intent(this, UnitTestingActivity::class.java)
                startActivity(mIntent)
            }

            R.id.btn_to_background_thread -> {
                val mIntent = Intent(this, BackgroundThreadActivity::class.java)
                startActivity(mIntent)
            }

            R.id.btn_to_service -> {
                val mIntent = Intent(this, ServiceActivity::class.java)
                startActivity(mIntent)
            }

            R.id.btn_to_broadcast_receiver -> {
                val mIntent = Intent(this, BroadcastReceiverActivity::class.java)
                startActivity(mIntent)
            }

            R.id.btn_to_alarm_manager -> {
                val mIntent = Intent(this, AlarmManagerActivity::class.java)
                startActivity(mIntent)
            }

            R.id.btn_to_json -> {
                val mIntent = Intent(this, JsonActivity::class.java)
                startActivity(mIntent)
            }
        }
    }
}