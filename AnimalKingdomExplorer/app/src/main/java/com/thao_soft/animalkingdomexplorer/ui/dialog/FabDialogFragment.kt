package com.thao_soft.animalkingdomexplorer.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.textfield.TextInputEditText
import com.thao_soft.animalkingdomexplorer.R
import com.thao_soft.animalkingdomexplorer.data.model.Animal
import com.thao_soft.animalkingdomexplorer.data.model.Species
import com.thao_soft.animalkingdomexplorer.ui.animaldetails.AnimalDetailsViewModel
import com.thao_soft.animalkingdomexplorer.ui.speciesdetails.SpeciesDetailsViewModel

class FabDialogFragment : DialogFragment() {
    private var type: Int? = null

    private val animalDetailsViewModel: AnimalDetailsViewModel by activityViewModels()
    private val speciesDetailsViewModel: SpeciesDetailsViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        type = arguments?.getInt("type")
    }

    override fun onStart() {
        super.onStart()
        if (dialog != null) {
            dialog!!.window!!.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = when (type) {
            0 -> {
                inflater.inflate(R.layout.fragment_animal_dialog, container, false)
            }

            1 -> {
                inflater.inflate(R.layout.fragment_species_dialog, container, false)
            }

            else -> {
                super.onCreateView(inflater, container, savedInstanceState)
            }
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when (type) {
            0 -> {
                view.findViewById<Button>(R.id.addAnimalItem).setOnClickListener {
                    val name =
                        view.findViewById<TextInputEditText>(R.id.nameTxtField).text.toString()
                    val habitat =
                        view.findViewById<TextInputEditText>(R.id.habitatTxtField).text.toString()
                    val diet =
                        view.findViewById<TextInputEditText>(R.id.dietTxtField).text.toString()
                    animalDetailsViewModel.addAnimalDetails(
                        Animal(
                            name = name,
                            habitat = habitat,
                            diet = diet
                        )
                    )
                    dismiss()
                }
            }

            1 -> {
                view.findViewById<Button>(R.id.addSpeciesItem).setOnClickListener {
                    val name =
                        view.findViewById<TextInputEditText>(R.id.nameTxtField).text.toString()
                    val description =
                        view.findViewById<TextInputEditText>(R.id.descriptionTxtField).text.toString()
                    speciesDetailsViewModel.addSpecies(
                        Species(
                            name = name,
                            description = description
                        )
                    )
                    dismiss()
                }
            }
        }

    }
}