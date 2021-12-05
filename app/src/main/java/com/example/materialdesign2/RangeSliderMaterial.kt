package com.example.materialdesign2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.materialdesign2.databinding.FragmentRangeSliderBinding
import com.google.android.material.slider.RangeSlider


class RangeSliderMaterial : Fragment() {

    private lateinit var binding: FragmentRangeSliderBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_range_slider, container, false)
        // Inflate the layout for this fragment
        binding.rangeSlider.addOnSliderTouchListener(object :RangeSlider.OnSliderTouchListener{
            override fun onStartTrackingTouch(slider: RangeSlider) {
                binding.selectedPart.text = "Идет выбор"
            }

            override fun onStopTrackingTouch(slider: RangeSlider) {
                binding.selectedPart.text = "Выбор сделан"
            }
        })
        binding.rangeSlider.addOnChangeListener { slider, value, fromUser ->
            val values = slider.values
            val valueFrom = values[0].toInt()
            val valueTo = values[1].toInt()
            binding.descSelectedPart.text = getString(R.string.yourSelectedRange,valueFrom,valueTo)
        }

        return binding.root
    }
}