package com.example.fundamental

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class DetailCategoryFragment : Fragment() {

    var description: String? = null

    companion object {
        var EXTRA_NAME = "extra_name"
        var EXTRA_DETAIL = "extra_detail"
    }

    private lateinit var tvReceivedName: TextView
    private lateinit var tvReceivedDescription: TextView
    private lateinit var btnProfile: Button
    private lateinit var btnShowDialog: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvReceivedName = view.findViewById(R.id.tv_received_category_name)
        tvReceivedDescription = view.findViewById(R.id.tv_received_category_description)
        btnProfile = view.findViewById(R.id.btn_profile)
        btnShowDialog = view.findViewById(R.id.btn_show_dialog)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (savedInstanceState != null) {
            val descFormBundle = savedInstanceState.getString(EXTRA_DETAIL)
            description = descFormBundle
        }

        if (arguments != null){
            val categoryName = arguments?.getString(EXTRA_NAME)
            tvReceivedName.text = categoryName
            tvReceivedDescription.text = description
        }
    }


}