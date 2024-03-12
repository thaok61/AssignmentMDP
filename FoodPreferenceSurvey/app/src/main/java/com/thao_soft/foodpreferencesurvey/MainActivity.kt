package com.thao_soft.foodpreferencesurvey

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {
    private var selectedSurvey = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RadioButton>(R.id.foodRadioBtn).setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                selectedSurvey = 0
            }

        }

        findViewById<RadioButton>(R.id.dietaryRadioBtn).setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                selectedSurvey = 1
            }
        }

        findViewById<Button>(R.id.submit).setOnClickListener { _ ->
            val intent = Intent(this, SurveyActivity::class.java)
            intent.putExtra("type", selectedSurvey)
            startActivity(intent)
        }
    }
}