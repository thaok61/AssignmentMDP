package com.thao_soft.sportnewsandinformation.fragments.sport_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.thao_soft.sportnewsandinformation.R
import com.thao_soft.sportnewsandinformation.common.fragments.CommonListFragment
import com.thao_soft.sportnewsandinformation.fragments.sport_fragment.adapter.MySportRecyclerViewAdapter
import com.thao_soft.sportnewsandinformation.fragments.sport_fragment.placeholder.SportContent

/**
 * A fragment representing a list of Items.
 */
class SportFragment : Fragment(), CommonListFragment {

    private var columnCount = 2
    private lateinit var mySportRecyclerViewAdapter: MySportRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }

        mySportRecyclerViewAdapter =  MySportRecyclerViewAdapter(SportContent.ITEMS)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sport_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }

                adapter = mySportRecyclerViewAdapter
            }
        }
        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            SportFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    override fun refreshList() {
        val size = mySportRecyclerViewAdapter.itemCount
        mySportRecyclerViewAdapter.notifyItemInserted(size + 1)
    }
}