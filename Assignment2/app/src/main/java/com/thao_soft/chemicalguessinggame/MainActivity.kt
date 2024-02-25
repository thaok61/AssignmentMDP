package com.thao_soft.chemicalguessinggame

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.View.OnClickListener
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.thao_soft.chemicalguessinggame.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private val listChemical = mutableListOf("Gold")
    private var correctWordIdx = 0
    private val handler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        binding.title.text = getString(R.string.enter_a_chemical_name_or_guess)
        binding.guessButton.setOnClickListener(this)
        binding.addChemicalButton.setOnClickListener(this)
        getRandomWord()
    }

    private fun getRandomWord() {
        correctWordIdx = listChemical.indices.random()
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }

    private fun hideKeyboard() {
        try {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }
    }

    private fun guess() {
        val enterText: String = binding.guessInputText.text.toString()

        if (enterText.isNotBlank()) {

            if (enterText.lowercase() == listChemical[correctWordIdx].lowercase()) {
                binding.title.text = getString(R.string.correct_guess, listChemical[correctWordIdx])
            } else {
                binding.title.text =
                    getString(R.string.incorrect_guess, listChemical[correctWordIdx])
            }
            changeDefaultTitle()

        }
        getRandomWord()
        hideKeyboard()
    }

    private fun changeDefaultTitle() {
        handler.removeCallbacksAndMessages(null)
        handler.postDelayed(
            {
                binding.title.text = getString(R.string.enter_a_chemical_name_or_guess)
            }, 5000)
    }

    private fun addChemical() {
        val newChemical = binding.addChemicalInputText.text.toString()
        if (newChemical.isNotBlank()) {
            var canAdd = true
            for (i in listChemical.indices) {
                if (listChemical[i].lowercase() == newChemical.lowercase()) {
                    canAdd = false
                    break
                }
            }
            if (canAdd) {
                listChemical.add(newChemical)
                binding.title.text = getString(R.string.add_chemical_success, newChemical)
            } else {
                binding.title.text = getString(R.string.add_chemical_fail, newChemical)
            }
        } else {
            binding.title.text = getString(R.string.empty_chemical)
        }

        changeDefaultTitle()
        hideKeyboard()
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.guessButton -> guess()

            R.id.addChemicalButton -> addChemical()
        }
    }


}