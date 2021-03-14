package com.example.fundamental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class IntentActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        val btnMoveWithString: Button = findViewById(R.id.btn_move_with_string)
        btnMoveWithString.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_move_with_string -> {
                val intentWithString = Intent(this, IntentWithStringActivity::class.java)
                intentWithString.putExtra(IntentWithStringActivity.EXTRA_NAME, "My Name is My Name")
                intentWithString.putExtra(IntentWithStringActivity.EXTRA_OTHER, "Other value is value other than this")
                startActivity(intentWithString)
            }

            R.id.btn_move_with_object -> {

                val person = Person(
                    "My Name is My Name",
                    1,
                    "Itsokay@gmail.ch",
                    "I Live where I live"
                )

                val intentWithObject = Intent(this, IntentWithObjectActivity::class.java)
                intentWithObject.putExtra(IntentWithObjectActivity.EXTRA_OBJECT, person)
                startActivity(intentWithObject)
            }
        }

    }
}