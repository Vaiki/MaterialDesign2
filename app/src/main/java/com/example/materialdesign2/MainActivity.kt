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
        binding.SliderButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.SliderButton ->{supportFragmentManager.beginTransaction().replace(R.id.contentFragment,SliderMaterial()).commit()}
        }

    }
}