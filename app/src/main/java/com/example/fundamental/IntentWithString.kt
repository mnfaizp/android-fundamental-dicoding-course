package com.example.fundamental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class IntentWithString : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_OTHER = "extra_other"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_with_string)

        val tvNameReceived: TextView = findViewById(R.id.tv_received_name)
        val tvOtherReceived: TextView = findViewById(R.id.tv_received_other)

        val name = intent.getStringExtra(EXTRA_NAME)
        val other = intent.getStringExtra(EXTRA_OTHER)

        val text = "Get the value from here and go $name and $other"
    }
}