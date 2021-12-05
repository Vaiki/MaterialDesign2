package com.example.materialdesign2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.materialdesign2.databinding.FragmentCheckBoxMaterialBinding
import com.google.android.material.snackbar.Snackbar


class CheckBoxMaterial : Fragment() {
    private lateinit var binding: FragmentCheckBoxMaterialBinding
    private var thisContext: Context? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        thisContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_check_box_material,
            container,
            false
        )

        binding.checkbox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Snackbar.make(buttonView, "Добавлено в избранное", Snackbar.LENGTH_LONG)
                    .setAction("ACTION") {}
                    .setBackgroundTint(context?.let {ContextCompat.getColor(it,R.color.black)}!!)
                    .setTextColor(context?.let { ContextCompat.getColor(it, R.color.white) }!!)
                    .setActionTextColor(context?.let {ContextCompat.getColor(it,R.color.orange)}!!)
                    .show()


            }

        }

        return binding.root
    }


}