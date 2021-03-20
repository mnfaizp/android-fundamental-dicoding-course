package com.example.fundamental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.example.fundamental.databinding.ActivityCustomViewBinding

class CustomViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomViewBinding.inflate(layoutInflater)
        setContentView(binding.root)



        setCustomButtonEnabled()

        binding.edtCustom.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                setCustomButtonEnabled()
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

        binding.btnCustom.setOnClickListener {
            Toast.makeText(this, binding.edtCustom.text, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setCustomButtonEnabled() {
        val result = binding.edtCustom.text
        binding.btnCustom.isEnabled = result != null && result.toString().isNotEmpty()
    }


}