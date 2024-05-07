package com.thao_soft.animalkingdomexplorer.ui.speciesdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thao_soft.animalkingdomexplorer.R
import com.thao_soft.animalkingdomexplorer.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * A fragment representing a list of Items.
 */
@AndroidEntryPoint
class SpeciesDetailsFragment : Fragment() {

    private var columnCount = 1
    private lateinit var speciesAdapter: SpeciesAdapter
    private val speciesDetailsViewModel: SpeciesDetailsViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        speciesAdapter = SpeciesAdapter(listOf())
    }

    private val mainViewModel: MainViewModel by activityViewModels()
    override fun onStart() {
        super.onStart()
        mainViewModel.setTitle("Species Details")
        mainViewModel.setShowBackButton(true)
        mainViewModel.setCurrentTypeFabButton(1)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_species_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = speciesAdapter
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    speciesDetailsViewModel.species.collect {
                        speciesAdapter.updateData(it)
                    }
                }
            }
        }
    }
}