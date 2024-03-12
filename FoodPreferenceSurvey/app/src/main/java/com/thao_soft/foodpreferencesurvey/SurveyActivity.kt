package com.thao_soft.foodpreferencesurvey

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.annotation.StringRes

class SurveyActivity : AppCompatActivity() {
    private var type = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey)
        type = intent.getIntExtra("type", 0)
        val title = findViewById<TextView>(R.id.title)
        val foodPreferences = findViewById<LinearLayout>(R.id.foodQuestions)
        val dietaryHabits = findViewById<LinearLayout>(R.id.dietaryQuestions)
        if (type == 0) {
            title.text = "Food Preferences"
            foodPreferences.visibility = View.VISIBLE
            dietaryHabits.visibility = View.GONE
        } else {
            title.text = "Dietary Habits"
            dietaryHabits.visibility = View.VISIBLE
            foodPreferences.visibility = View.GONE
        }

        findViewById<Button>(R.id.submitBtn).setOnClickListener { _ ->
            renderResult()
        }
    }

    private fun renderResultLine(@IdRes radioGroupId: Int, @StringRes questionId: Int): TextView {
        val radioGroup = findViewById<RadioGroup>(radioGroupId)
        val selectedRadioButton = findViewById<RadioButton>(radioGroup.checkedRadioButtonId)

        val resultString = getString(questionId) + " " + selectedRadioButton.text

        val textView = TextView(this)
        textView.text = resultString
        return textView
    }

    private fun renderResult() {
        val resultLinearLayout = findViewById<LinearLayout>(R.id.resultSurvey)

        resultLinearLayout.removeAllViews()
        if (type == 0) {
            resultLinearLayout.addView(
                renderResultLine(
                    R.id.favoriteCuisine,
                    R.string.what_is_your_favorite_cuisine
                )
            )

            resultLinearLayout.addView(
                renderResultLine(
                    R.id.oftenDoYouEat,
                    R.string.how_often_do_you_eat_out
                )
            )

            resultLinearLayout.addView(
                renderResultLine(
                    R.id.spicyFood,
                    R.string.do_you_prefer_spicy_food
                )
            )

            resultLinearLayout.addView(
                renderResultLine(
                    R.id.vegetarianFood,
                    R.string.do_you_prefer_vegetarian_food
                )
            )

            resultLinearLayout.addView(
                renderResultLine(
                    R.id.seaFood,
                    R.string.do_you_like_seafood
                )
            )
        } else {
            resultLinearLayout.addView(
                renderResultLine(
                    R.id.vegetarian,
                    R.string.are_you_vegetarian
                )
            )

            resultLinearLayout.addView(
                renderResultLine(
                    R.id.organicFood,
                    R.string.do_you_prefer_organic_food
                )
            )

            resultLinearLayout.addView(
                renderResultLine(
                    R.id.dairyProducts,
                    R.string.do_you_consume_dairy_products
                )
            )

            resultLinearLayout.addView(
                renderResultLine(
                    R.id.fastFood,
                    R.string.do_you_eat_fast_food
                )
            )

            resultLinearLayout.addView(
                renderResultLine(
                    R.id.allergies,
                    R.string.do_you_have_any_food_allergies
                )
            )
        }
    }
}