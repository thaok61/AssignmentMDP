package com.thao_soft.sportnewsandinformation.fragments.historical_archive_fragment.placeholder

import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object ArchiveContent {

    /**
     * An array of sample (placeholder) items.
     */
    val ITEMS: MutableList<ArchiveItem> = ArrayList()


    init {
        addItem(
            "First Modern Olympic Games",
            "April 6, 1896",
            "The first modern Olympic Games were held in Athens Greece, and marked the revival of the ancient Olympic Games"
        )

        addItem(
            "Jesse Owens at the 1936 Olympics",
            "August 3-12, 1936",
            "American athlete Jesse Owens won four gold medals in track and field events at the 1936 Berlin Olympics, defying Adolf Hitler's Aryan supremacy ideology"
        )
    }

    fun addItem(name: String, date: String, description: String) {
        ITEMS.add(createPlaceholderItem(name, date, description))
    }

    private fun createPlaceholderItem(
        name: String,
        date: String,
        description: String
    ): ArchiveItem {
        return ArchiveItem(name, date, description)
    }

    /**
     * A placeholder item representing a piece of content.
     */
    data class ArchiveItem(val name: String, val date: String, val description: String)
}