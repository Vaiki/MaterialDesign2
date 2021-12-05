package com.example.materialdesign2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.materialdesign2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
   private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.sliderButton.setOnClickListener(this)
        binding.rangeSliderButton.setOnClickListener(this)
        binding.outlinedButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.sliderButton ->supportFragmentManager.beginTransaction().replace(R.id.contentFragment,SliderMaterial()).commit()
            R.id.rangeSliderButton ->supportFragmentManager.beginTransaction().replace(R.id.contentFragment,RangeSliderMaterial()).commit()
            R.id.outlinedButton->supportFragmentManager.beginTransaction().replace(R.id.contentFragment,CheckBoxMaterial()).commit()
        }

    }
}