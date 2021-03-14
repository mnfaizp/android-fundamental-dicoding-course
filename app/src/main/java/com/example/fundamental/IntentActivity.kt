package com.example.fundamental

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class IntentActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvResult: TextView

    companion object {
        private const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        val btnMoveWithString: Button = findViewById(R.id.btn_move_with_string)
        btnMoveWithString.setOnClickListener(this)

        val btnMoveWithObject: Button = findViewById(R.id.btn_move_with_object)
        btnMoveWithObject.setOnClickListener(this)

        val btnMoveWithResult: Button = findViewById(R.id.btn_move_with_result)
        btnMoveWithResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_received_result)
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

            R.id.btn_move_with_result -> {
                val intentWithResult = Intent(this, IntentWithResultActivity::class.java)
                startActivityForResult(intentWithResult, REQUEST_CODE)
            }
        }

    }

    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (resultCode == IntentWithResultActivity.RESULT_CODE) {
                val selectedValue = data?.getIntExtra(IntentWithResultActivity.EXTRA_SELECTED_VALUE, 0)
                tvResult.text = "Hasil : $selectedValue"
            }
        }
    }
}