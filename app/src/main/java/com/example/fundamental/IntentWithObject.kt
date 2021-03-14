package com.example.fundamental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class IntentWithObject : AppCompatActivity() {

    companion object {
        val EXTRA_OBJECT = "extra_object"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_with_object)

        val tvReceivedObject: TextView = findViewById(R.id.tv_received_object)

        val person = intent.getParcelableExtra<Person>(EXTRA_OBJECT) as Person
        val text = "Name : ${person.name.toString()}, \nEmail : ${person.email.toString()}, \nAge : ${person.age}, \nCity : ${person.city.toString()}"

        tvReceivedObject.text = text
    }
}