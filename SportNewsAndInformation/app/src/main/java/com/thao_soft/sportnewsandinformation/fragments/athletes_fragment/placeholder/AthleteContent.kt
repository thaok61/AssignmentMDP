package com.thao_soft.sportnewsandinformation.fragments.athletes_fragment.placeholder

import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object AthleteContent {

    /**
     * An array of sample (placeholder) items.
     */
    val ITEMS: MutableList<AthleteItem> = ArrayList()

    init {
        // Add some sample items.
        addItem(
            "Name: Usain Bolt",
            "Sport: Track and Field",
            "Country: Jamaica",
            "Personal Best: 100m - 9.58s",
            "Medals Awarded: 8",
            "Facts: Usain Bolt holds the world record for both the 100 meters and 200 meters."
        )
        addItem(
            "Name: Simone Biles",
            "Sport: Gymnastics",
            "Country: United States",
            "Personal Best: N/A",
            "Medals Awarded: 7",
            "Facts: Simone Biles is considered one of the greatest gymnasts of all time."
        )

        addItem(
            "Name: Michael Phelps",
            "Sport: Swimming",
            "Country: United States",
            "Personal Best: 23 Olympic Gold Medals",
            "Medals Awarded: 28",
            "Facts: Michael Phelps holds the record for the most Olympic gold medals won by any athlete."
        )
    }

    fun addItem(
        athleteName: String,
        sportName: String,
        country: String,
        bestPerformance: String,
        medals: String,
        facts: String
    ) {
        ITEMS.add(
            createPlaceholderItem(
                athleteName,
                sportName,
                country,
                bestPerformance,
                medals,
                facts
            )
        )
    }

    private fun createPlaceholderItem(
        athleteName: String,
        sportName: String,
        country: String,
        bestPerformance: String,
        medals: String,
        facts: String
    ): AthleteItem {
        return AthleteItem(athleteName, sportName, country, bestPerformance, medals, facts)
    }

    /**
     * A placeholder item representing a piece of content.
     */
    data class AthleteItem(
        val athleteName: String,
        val sportName: String,
        val country: String,
        val bestPerformance: String,
        val medals: String,
        val facts: String,
    )
}