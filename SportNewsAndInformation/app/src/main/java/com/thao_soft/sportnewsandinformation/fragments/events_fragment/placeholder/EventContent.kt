package com.thao_soft.sportnewsandinformation.fragments.events_fragment.placeholder

import java.util.ArrayList
import java.util.Date
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object EventContent {

    /**
     * An array of sample (placeholder) items.
     */
    val ITEMS: MutableList<EventItem> = ArrayList()

    init {
        // Add some sample items.
        addItem(
            "FIBA Basketball World Cup Qualifiers",
            "Qualifying games for the 2025 FIBA Basketball World Cup",
            "10/03/2024",
        )

        addItem(
            "Indian Premier League (IPL)",
            "Twenty20 cricket league in India",
            "03/15/2024",
        )
    }

    fun addItem(name: String, description: String, date: String) {
        ITEMS.add(createPlaceholderItem(name, description, date))
    }

    private fun createPlaceholderItem(name: String, description: String, date: String): EventItem {
        return EventItem(name, description, date)
    }

    /**
     * A placeholder item representing a piece of content.
     */
    data class EventItem(val name: String, val description: String, val date: String)
}