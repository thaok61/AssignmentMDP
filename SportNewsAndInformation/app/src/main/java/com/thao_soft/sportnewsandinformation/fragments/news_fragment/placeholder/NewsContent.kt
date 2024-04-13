package com.thao_soft.sportnewsandinformation.fragments.news_fragment.placeholder

import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object NewsContent {

    /**
     * An array of sample (placeholder) items.
     */
    val ITEMS: MutableList<NewsItem> = ArrayList()

    /**
     * A map of sample (placeholder) items, by ID.
     */

    init {
        // Add some sample items.
        addItem(
            "https://media.cnn.com/api/v1/images/stellar/prod/2024-04-08t220304z-779078819-up1ek481nsfe0-rtrmadp-3-soccer-saudi-alh-ana-report.jpg?c=16x9&q=h_653,w_1160,c_fill/f_webp",
            "Cristiano Ronaldo red carded for elbowing opponent during Saudi Super Cup defeat",
            "Cristiano Ronaldo was red carded for elbowing an opponent during Al-Nassr’s defeat against Al-Hilal in the Saudi Super Cup semifinal.\n" +
                    "\n" +
                    "The incident occurred late in Monday’s game in Abu Dhabi when the Portuguese striker found himself in a tussle with Al-Hilal’s Ali Al-Bulayhi during second-half stoppage time.\n" +
                    "\n" +
                    "He was shown a straight red card for thrusting his elbow at center back Al-Bulayhi’s chest and throat, then appeared to raise his fist towards the referee.\n" +
                    "\n" +
                    "Sadio Mané did score for Al-Nassr following Ronaldo’s departure, but earlier goals from Salem Al-Dawsari and Malcom gave Al-Hilal a 2-1 victory."
        )

        addItem(
            "https://media.cnn.com/api/v1/images/stellar/prod/gettyimages-2049058276.jpg?c=16x9&q=h_438,w_780,c_fill",
            "‘My entire M.O. is have fun,’ says Tara Davis-Woodhall, the ‘free-spirited’ US long jump star",
            "Skipping down the running track with a cowboy hat on her head and a grin across her face, Tara Davis-Woodhall hardly has the demeanor of an athlete about to win the biggest title of her career.\n" +
                    "\n" +
                    "However, when the hat comes off an aura of focus descends upon the American track and field star and she produces a performance that is one of her best to date, a huge jump of more than seven meters to take gold and remain undefeated for the year.\n" +
                    "\n" +
                    "That was several weeks ago, at the indoor world championships in Glasgow, Scotland, and with the gold medal came celebrations which were joyous and effervescent: the cowboy hat returned, so too did the smiling and the dancing along the side of the track."
        )
    }

    fun addItem(url: String, title: String, description: String) {
        ITEMS.add(createPlaceholderItem(url, title, description))
    }

    private fun createPlaceholderItem(url: String, title: String, description: String): NewsItem {
        return NewsItem(url, title, description)
    }


    /**
     * A placeholder item representing a piece of content.
     */
    data class NewsItem(val url: String, val title: String, val description: String)
}