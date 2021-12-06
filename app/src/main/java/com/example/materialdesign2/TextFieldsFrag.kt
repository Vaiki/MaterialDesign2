package com.example.materialdesign2

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.materialdesign2.databinding.FragmentTextFieldsBinding
import com.google.android.material.snackbar.Snackbar

class TextFieldsFrag : Fragment(), View.OnKeyListener {
    private lateinit var binding: FragmentTextFieldsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_text_fields, container, false)
        binding.enterCity.setOnKeyListener(this)//слушатель ввода данных в editText

        binding.sectionEnterCity.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, count: Int) {

                when {
                    count > 7 -> binding.sectionEnterCity.error = getString(R.string.item1)
                    count < 1 -> binding.sectionEnterCity.helperText = getString(R.string.item2)
                }
                binding.error.text = p0
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })// проводим операции с содержимым editText


        binding.sectionEnterCity.setEndIconOnClickListener {
            Snackbar.make(it, R.string.item1, Snackbar.LENGTH_LONG)
                .setBackgroundTint(context?.let { it1 ->
                    ContextCompat.getColor(
                        it1,
                        R.color.blue
                    )
                }!!)
                .setTextColor(context?.let { ContextCompat.getColor(it, R.color.black) }!!)
                .setActionTextColor(context?.let {ContextCompat.getColor(it,R.color.orange)}!!)
                .setAction(R.string.yes) {}
                .show()
        } //слушатель нажатия на иконку в конце editText


        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onKey(v: View?, i: Int, keyEvent: KeyEvent?): Boolean {
        when (v?.id) {
            R.id.enterCity -> {
                if (keyEvent?.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {
                    binding.resultTextFields.text = binding.enterCity.text
                    binding.enterCity.setText("")
                    return true
                }
            }
        }
        return false
    }

}