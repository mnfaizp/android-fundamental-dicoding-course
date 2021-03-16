package com.example.fundamental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ListViewActivity : AppCompatActivity() {

    private val dataName = arrayOf("Cut Nyak Dien",
        "Ki Hajar Dewantara",
        "Moh Yamin",
        "Pattimura",
        "R A Kartini",
        "Sukarno")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val lvHeroes: ListView = findViewById(R.id.lv_heroes)
        val adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, android.R.id.text1, dataName)
        lvHeroes.adapter = adapter

    }
}