package com.thao_soft.storingwaterresource

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.View.OnClickListener
import android.view.inputmethod.InputMethodManager
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.DataBindingUtil
import com.thao_soft.storingwaterresource.databinding.ActivityMainBinding
import com.thao_soft.storingwaterresource.model.RiverResource

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    val list = mutableListOf<RiverResource>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.addBtn.setOnClickListener(this)
        addNewRow(getString(R.string.water_resource_name),
            getString(R.string.location), getString(R.string.type))
    }

    private fun addNewRow(name: String, location: String, type: String) {
        val titleRow = TableRow(this)

        val nameText = TextView(this)
        nameText.background = AppCompatResources.getDrawable(this, R.drawable.cell_shape)
        nameText.text = name
        nameText.gravity = Gravity.CENTER


        val locationText = TextView(this)
        locationText.background = AppCompatResources.getDrawable(this, R.drawable.cell_shape)
        locationText.text = location
        locationText.gravity = Gravity.CENTER


        val typeText = TextView(this)
        typeText.background = AppCompatResources.getDrawable(this, R.drawable.cell_shape)
        typeText.text = type
        typeText.gravity = Gravity.CENTER

        titleRow.addView(nameText)
        titleRow.addView(locationText)
        titleRow.addView(typeText)
        binding.tableRiver.addView(titleRow)
    }

    private fun addNewName() {
        val name = binding.resourceName.text.toString()
        val location = binding.location.text.toString()
        val type = binding.type.text.toString()

        Log.d("MainActivity", "addNewName: RUN")

        if (name.isNotBlank() && location.isNotBlank() && type.isNotBlank()) {
            addNewRow(name, location, type)
            binding.resourceName.setText("")
            binding.location.setText("")
            binding.type.setText("")
        }

        hideKeyboard()
    }

    private fun hideKeyboard() {
        try {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }
    }

    override fun onClick(view: View?) {
        when(view?.id) {
             R.id.add_btn -> addNewName()
        }
    }

}