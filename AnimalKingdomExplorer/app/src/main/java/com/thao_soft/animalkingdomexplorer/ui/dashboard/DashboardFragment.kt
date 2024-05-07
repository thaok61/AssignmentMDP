package com.thao_soft.animalkingdomexplorer.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.thao_soft.animalkingdomexplorer.R
import com.thao_soft.animalkingdomexplorer.ui.MainViewModel

class DashboardFragment : Fragment() {

    private val navController: NavController by lazy {
        findNavController()
    }

    private val mainViewModel: MainViewModel by activityViewModels()
    override fun onStart() {
        super.onStart()
        mainViewModel.setTitle("Home")
        mainViewModel.setShowBackButton(false)
        mainViewModel.setCurrentTypeFabButton(-1)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.animalDetailsBtn).setOnClickListener {
            navController.navigate("animal_details")
        }

        view.findViewById<Button>(R.id.speciesDetailsBtn).setOnClickListener {
            navController.navigate("species_details")
        }
    }
}