package com.example.materialdesign2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.materialdesign2.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.sliderButton.setOnClickListener(this)
        binding.rangeSliderButton.setOnClickListener(this)
        binding.outlinedButton.setOnClickListener(this)
        binding.outlinedIconButton.setOnClickListener(this)
        binding.dialogBtn.setOnClickListener(this)
        binding.multiDialog.setOnClickListener(this)
    }


    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.sliderButton -> supportFragmentManager.beginTransaction()
                .replace(R.id.contentFragment, SliderMaterial()).commit()
            R.id.rangeSliderButton -> supportFragmentManager.beginTransaction()
                .replace(R.id.contentFragment, RangeSliderMaterial()).commit()
            R.id.outlinedButton -> supportFragmentManager.beginTransaction()
                .replace(R.id.contentFragment, CheckBoxMaterial()).commit()
            R.id.outlinedIconButton -> supportFragmentManager.beginTransaction()
                .replace(R.id.contentFragment, Toggle()).commit()
            R.id.dialog_Btn -> {
                val builder = MaterialAlertDialogBuilder(this, R.style.MyDialogTheme)

                    .setTitle(resources.getString(R.string.item1))
                    .setMessage(resources.getString(R.string.item2))

                    .setNeutralButton(resources.getString(R.string.close)) { dialog, which ->
                        loadNeutral()
                    }
                    .setNegativeButton(resources.getString(R.string.no)) { dialog, which ->
                        loadNegative()
                    }
                    .setPositiveButton(resources.getString(R.string.yes)) { dialog, which ->
                        loadPositive()
                    }
                    .show()

                textColorDialog(builder)

            }
            R.id.multiDialog -> {
                val multiItems = arrayOf(
                    resources.getString(R.string.onePart), resources.getString(R.string.twoPart),
                    resources.getString(R.string.threePart)
                )
                val checkedItems = booleanArrayOf(false, false, false)
                val selectedPart = ArrayList<Any>()

                val builder = MaterialAlertDialogBuilder(this, R.style.MyDialogTheme)
                    .setTitle(resources.getString(R.string.item1))
                    .setNeutralButton(resources.getString(R.string.close)) { dialog, which ->
                        loadNeutral()
                    }
                    .setNegativeButton(resources.getString(R.string.no)) { dialog, which ->
                        loadNegative()
                    }
                    .setPositiveButton(resources.getString(R.string.yes)) { dialog, which ->
                        val getParts = selectedPart.toString().
                        replace("[", "").replace("]", "")
                        binding.result.text =
                            resources.getString(R.string.yourSelectedPart) + " " + getParts
                    }
                    .setMultiChoiceItems(multiItems, checkedItems) { dialog, which, checked ->
                        if (checked) selectedPart.add(multiItems[which])
                        else selectedPart.remove(multiItems[which])
                    }
                    .show()
                textColorDialog(builder)
            }

        }

    }

    private fun textColorDialog(builder: AlertDialog){
        builder.getButton(AlertDialog.BUTTON_POSITIVE)
            .setTextColor(ContextCompat.getColor(this, R.color.black))
        builder.getButton(AlertDialog.BUTTON_NEGATIVE)
            .setTextColor(ContextCompat.getColor(this, R.color.black))
        builder.getButton(AlertDialog.BUTTON_NEUTRAL)
            .setTextColor(ContextCompat.getColor(this, R.color.black))
    }
    private fun loadPositive() {
        binding.result.text = getString(R.string.actionPositive)
    }

    private fun loadNeutral() {
        binding.result.text = getString(R.string.actionNeutral)
    }

    private fun loadNegative() {
        binding.result.text = getString(R.string.actionNegative)
    }

}