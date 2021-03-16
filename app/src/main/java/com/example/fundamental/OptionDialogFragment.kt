package com.example.fundamental

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment

class OptionDialogFragment : DialogFragment() {

    private lateinit var btnChoose: Button
    private lateinit var btnClose: Button
    private lateinit var rgChooseStronger: RadioGroup
    private lateinit var rbLuBu: RadioButton
    private lateinit var rbHonTad: RadioButton
    private lateinit var rbGM: RadioButton
    private lateinit var rbKr: RadioButton
    private var optionDialogListener: OnOptionDialogListener? = null

    interface OnOptionDialogListener {
        fun onOptionChosen(text: String?)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_option_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnChoose = view.findViewById(R.id.btn_choose)
        btnClose = view.findViewById(R.id.btn_close_dialog)
        rgChooseStronger = view.findViewById(R.id.rg_choose_stronger)
        rbLuBu = view.findViewById(R.id.rb_lb)
        rbHonTad = view.findViewById(R.id.rb_hk)
        rbGM = view.findViewById(R.id.rb_gm)
        rbKr = view.findViewById(R.id.rb_kr)

        btnChoose.setOnClickListener {
            val checkedRadioButton = rgChooseStronger.checkedRadioButtonId
            if (checkedRadioButton != -1) {
                var strong: String? = null
                when (checkedRadioButton) {
                    R.id.rb_lb -> strong = rbLuBu.text.toString().trim()

                    R.id.rb_hk -> strong = rbHonTad.text.toString().trim()

                    R.id.rb_gm -> strong = rbGM.text.toString().trim()

                    R.id.rb_kr -> strong = rbKr.text.toString().trim()
                }

                optionDialogListener?.onOptionChosen(strong)
                dialog?.dismiss()
            }
        }

        btnClose.setOnClickListener {
            dialog?.cancel()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val fragment = parentFragment

        if (fragment is DetailCategoryFragment) {
            val detailCategoryFragement = fragment
            this.optionDialogListener = detailCategoryFragement.optionDialogListener
        }
    }

    override fun onDetach() {
        super.onDetach()

        this.optionDialogListener = null
    }
}