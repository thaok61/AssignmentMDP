package com.thao_soft.sportnewsandinformation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.thao_soft.sportnewsandinformation.adapter.AllSportsFragmentAdapter
import com.thao_soft.sportnewsandinformation.common.fragments.CommonListFragment
import com.thao_soft.sportnewsandinformation.databinding.ActivityMainBinding
import com.thao_soft.sportnewsandinformation.fragments.dialog_fragment.FabDialogFragment

class MainActivity : AppCompatActivity() {

    private lateinit var allSportsFragmentAdapter: AllSportsFragmentAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var bottomNavigation: BottomNavigationView

    private lateinit var binding: ActivityMainBinding

    fun refreshFragmentList() {
        val fragment = supportFragmentManager.findFragmentByTag("f${viewPager.currentItem}")

        if (viewPager.currentItem != 5) {
            val commonFragment = fragment as CommonListFragment
            commonFragment.refreshList()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        allSportsFragmentAdapter = AllSportsFragmentAdapter(this)
        val view = binding.root
        setContentView(view)
        viewPager = binding.sportViewPager
        viewPager.adapter = allSportsFragmentAdapter

        tabLayout = binding.sportTabLayout
        bottomNavigation = binding.sportsBottomNavigationBar

        binding.addFabBtn.setOnClickListener {
            val dialogFragment = FabDialogFragment()
            val bundle = Bundle()
            bundle.putInt("type", viewPager.currentItem)

            dialogFragment.arguments = bundle

            dialogFragment.show(
                supportFragmentManager,
                "${FabDialogFragment::class.java} ${viewPager.currentItem}"
            )
        }
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> {
                    "Sports"
                }

                1 -> {
                    "News"
                }

                2 -> {
                    "Athletes"
                }

                3 -> {
                    "Events"
                }

                4 -> {
                    "Historical Archives"
                }

                else -> {
                    "About Me"
                }
            }

        }.attach()

        bottomNavigation.selectedItemId = R.id.elseMenuItem

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.newsMenuItem -> {
                    viewPager.setCurrentItem(1, true)
                }

                R.id.archivesMenuItem -> {
                    viewPager.setCurrentItem(4, true)
                }

                R.id.eventsMenuItem -> {
                    viewPager.setCurrentItem(3, true)
                }
            }
            true
        }

        viewPager.registerOnPageChangeCallback(onPageChangeCallback)

    }

    override fun onDestroy() {
        super.onDestroy()
        viewPager.unregisterOnPageChangeCallback(onPageChangeCallback)
    }

    private val onPageChangeCallback: OnPageChangeCallback = object : OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            if (position == 5) {
                binding.addFabBtn.visibility = View.GONE
            } else {
                binding.addFabBtn.visibility = View.VISIBLE
            }
            when (position) {
                1 -> bottomNavigation.selectedItemId = R.id.newsMenuItem
                3 -> bottomNavigation.selectedItemId = R.id.eventsMenuItem
                4 -> bottomNavigation.selectedItemId = R.id.archivesMenuItem
                else -> bottomNavigation.selectedItemId = R.id.elseMenuItem
            }
        }
    }
}