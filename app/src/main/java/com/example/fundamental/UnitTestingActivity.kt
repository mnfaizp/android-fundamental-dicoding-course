package com.example.fundamental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class UnitTestingActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var cubeViewModel: CubeViewModel

    private lateinit var edtHeight: EditText
    private lateinit var edtWidth: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnSave: Button
    private lateinit var btnCountSurfaceArea: Button
    private lateinit var btnCountCircumference: Button
    private lateinit var btnCountVolume: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unit_testing)

        cubeViewModel = CubeViewModel(CuboidModel())

        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        edtWidth = findViewById(R.id.edt_width)
        btnSave = findViewById(R.id.btn_save)
        btnCountCircumference = findViewById(R.id.btn_count_circumference)
        btnCountSurfaceArea = findViewById(R.id.btn_count_surface_area)
        btnCountVolume = findViewById(R.id.btn_count_volume)
        tvResult = findViewById(R.id.tv_result)

        btnSave.setOnClickListener(this)
        btnCountVolume.setOnClickListener(this)
        btnCountSurfaceArea.setOnClickListener(this)
        btnCountCircumference.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val length = edtLength.text.toString().trim()
        val width = edtWidth.text.toString().trim()
        val height = edtHeight.text.toString().trim()

        when {
            length.isEmpty() -> edtLength.error = "This Field Cannot Empty"
            width.isEmpty() -> edtWidth.error = "This Field Cannot Empty"
            height.isEmpty() -> edtHeight.error = "This Field Cannot Empty"
            else -> {
                val l = length.toDouble()
                val h = height.toDouble()
                val w = width.toDouble()

                when {
                    v?.id == R.id.btn_save -> {
                        cubeViewModel.save(l, h, w)
                        visible()
                    }

                    v?.id == R.id.btn_count_volume -> {
                        tvResult.text = cubeViewModel.getVolume().toString()
                        gone()
                    }

                    v?.id == R.id.btn_count_surface_area -> {
                        tvResult.text = cubeViewModel.getSurfaceArea().toString()
                        gone()
                    }

                    v?.id == R.id.btn_count_circumference -> {
                        tvResult.text = cubeViewModel.getCircumference().toString()
                        gone()
                    }
                }
            }

        }
    }

    private fun gone() {
        btnCountCircumference.visibility = View.GONE
        btnCountSurfaceArea.visibility = View.GONE
        btnCountVolume.visibility = View.GONE
        btnSave.visibility = View.VISIBLE
    }

    private fun visible() {
        btnSave.visibility = View.GONE
        btnCountVolume.visibility = View.VISIBLE
        btnCountSurfaceArea.visibility = View.VISIBLE
        btnCountCircumference.visibility = View.VISIBLE
    }
}