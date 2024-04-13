package com.thao_soft.sportnewsandinformation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.thao_soft.sportnewsandinformation.fragments.about_me_fragment.AboutMeFragment
import com.thao_soft.sportnewsandinformation.fragments.athletes_fragment.AthletesFragment
import com.thao_soft.sportnewsandinformation.fragments.events_fragment.EventsFragment
import com.thao_soft.sportnewsandinformation.fragments.historical_archive_fragment.HistoricalArchiveFragment
import com.thao_soft.sportnewsandinformation.fragments.news_fragment.NewsFragment
import com.thao_soft.sportnewsandinformation.fragments.sport_fragment.SportFragment

class AllSportsFragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 6

    override fun createFragment(position: Int): Fragment {
        val fragment: Fragment = when(position) {
            0 -> {
                SportFragment()
            }

            1 -> {
                NewsFragment()
            }

            2-> {
                AthletesFragment()
            }

            3-> {
                EventsFragment()
            }

            4-> {
                HistoricalArchiveFragment()
            }

            else -> {
                AboutMeFragment()
            }
        }
        return fragment
    }
}