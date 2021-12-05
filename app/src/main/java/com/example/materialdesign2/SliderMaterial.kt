package com.example.materialdesign2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.materialdesign2.databinding.FragmentSliderBinding
import com.google.android.material.slider.Slider


class SliderMaterial : Fragment() {
private lateinit var binding: FragmentSliderBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_slider, container, false)
     binding.slider.addOnSliderTouchListener(object : Slider.OnSliderTouchListener{
         override fun onStartTrackingTouch(slider: Slider) {
           binding.selectedPart.text = "Идет выбор"
         }

         override fun onStopTrackingTouch(slider: Slider) {
             binding.selectedPart.text ="Выбор сделан"
         }
     })
       binding.slider.addOnChangeListener { slider, value, fromUser ->
          binding.descSelectedPart.text = getString(R.string.yourSelected,value.toInt())

       }
        return binding.root
    }

}