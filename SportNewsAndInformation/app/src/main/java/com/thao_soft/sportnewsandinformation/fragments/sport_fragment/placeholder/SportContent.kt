package com.thao_soft.sportnewsandinformation.fragments.sport_fragment.placeholder

import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object SportContent {


    /**
     * An array of sample (placeholder) items.
     */
    val ITEMS: MutableList<SportItem> = ArrayList()

    init {
        addItem(
            "Measure",
            "Running",
            "Keep your shoulders directly above your hips. Relax your arms, gaze straight ahead, and avoid looking down or at the monitor. Use a short stride, and take small steps. Running on a treadmill will force you to shorten your stride since overstriding will cause you to kick the front of the treadmill."
        )

        addItem(
            "Combat",
            "Boxing",
            "Punch with light but sharp punches to improve quality. ...\n" +
                    "Start with shorter combinations of punches. ...\n" +
                    "Drink plenty of water every day \uD83E\uDD5B ...\n" +
                    "Learn boxing while watching others\uD83D\uDCA1 ...\n" +
                    "Correct breathing technique \uD83D\uDCA8 ...\n" +
                    "Keep your head up. ...\n" +
                    "Get harder workouts gradually \uD83C\uDFC3♀\uFE0F"
        )
    }

    /**
     * A map of sample (placeholder) items, by ID.
     */

    fun addItem(type: String, name: String, instruction: String) {
        val item = createSportItem(type, name, instruction)
        ITEMS.add(item)
    }

    private fun createSportItem(type: String, name: String, instruction: String): SportItem {
        return SportItem(type, name, instruction)
    }

    /**
     * A placeholder item representing a piece of content.
     */
    data class SportItem(val type: String, val name: String, val instruction: String)
}