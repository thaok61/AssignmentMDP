package com.thao_soft.animalkingdomexplorer

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.createGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.dialog
import androidx.navigation.fragment.fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.thao_soft.animalkingdomexplorer.ui.MainViewModel
import com.thao_soft.animalkingdomexplorer.ui.animaldetails.AnimalDetailsFragment
import com.thao_soft.animalkingdomexplorer.ui.dashboard.DashboardFragment
import com.thao_soft.animalkingdomexplorer.ui.dialog.FabDialogFragment
import com.thao_soft.animalkingdomexplorer.ui.speciesdetails.SpeciesDetailsFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFragment.navController

        navController.graph = navController.createGraph(
            startDestination = "dashboard"
        ) {
            fragment<DashboardFragment>("dashboard") {
                label = "Dashboard"
            }

            fragment<AnimalDetailsFragment>("animal_details") {
                label = "Animal Details"
            }

            fragment<SpeciesDetailsFragment>("species_details") {
                label = "Species Details"
            }
            dialog<FabDialogFragment>("fab_dialog/{type}") {
                label = "Fab Dialog"
                argument("type") {
                    type = NavType.IntType
                }
            }
        }

        setSupportActionBar(findViewById(R.id.my_toolbar))

        findViewById<FloatingActionButton>(R.id.addFabBtn).setOnClickListener {
            navController.navigate("fab_dialog/${mainViewModel.currentTypeFabButton.value}")
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    mainViewModel.isShowBackButton.collect {
                        supportActionBar?.setDisplayHomeAsUpEnabled(it)
                    }
                }

                launch {
                    mainViewModel.title.collect {
                        supportActionBar?.title = it
                    }
                }

                launch {
                    mainViewModel.currentTypeFabButton.collect {
                        findViewById<FloatingActionButton>(R.id.addFabBtn).visibility =
                            if (it >= 0) View.VISIBLE else View.GONE
                    }
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        navController.navigateUp()
        return super.onSupportNavigateUp()
    }
}