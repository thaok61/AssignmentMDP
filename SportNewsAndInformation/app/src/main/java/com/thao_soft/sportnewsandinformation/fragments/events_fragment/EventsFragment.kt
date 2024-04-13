package com.thao_soft.sportnewsandinformation.fragments.events_fragment

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
import com.thao_soft.sportnewsandinformation.fragments.events_fragment.placeholder.EventContent

/**
 * A fragment representing a list of Items.
 */
class EventsFragment : Fragment(), CommonListFragment {

    private var columnCount = 1
    private lateinit var myEventRecyclerViewAdapter: MyEventRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }

        myEventRecyclerViewAdapter = MyEventRecyclerViewAdapter(EventContent.ITEMS)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_events_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = myEventRecyclerViewAdapter
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
            EventsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    override fun refreshList() {
        val position = myEventRecyclerViewAdapter.itemCount
        myEventRecyclerViewAdapter.notifyItemInserted(position + 1)
    }
}