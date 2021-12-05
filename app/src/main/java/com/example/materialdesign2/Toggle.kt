package com.example.materialdesign2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.materialdesign2.databinding.FragmentToggleBinding


class Toggle : Fragment() {
    private lateinit var binding: FragmentToggleBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_toggle, container, false)
      binding.toggleButton.addOnButtonCheckedListener { toggleButton, checkedId, isChecked ->
          if (isChecked){
              when(checkedId){
                  R.id.button1 ->binding.result.text = getString(R.string.item1)
                  R.id.button2 ->binding.result.text = getString(R.string.item2)
                  R.id.button3 ->binding.result.text = getString(R.string.item3)
              }
          }

      }
        return binding.root
    }


}