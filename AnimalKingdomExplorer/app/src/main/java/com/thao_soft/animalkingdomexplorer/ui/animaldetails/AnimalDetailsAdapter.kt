package com.thao_soft.animalkingdomexplorer.ui.animaldetails

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thao_soft.animalkingdomexplorer.data.model.Animal
import com.thao_soft.animalkingdomexplorer.databinding.FragmentAnimalItemBinding

class AnimalDetailsAdapter(
    private var values: List<Animal>
) : RecyclerView.Adapter<AnimalDetailsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentAnimalItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.name.text = item.name
        holder.habitat.text = item.habitat
        holder.diet.text = item.diet
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentAnimalItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val name: TextView = binding.name
        val habitat: TextView = binding.habitat
        val diet: TextView = binding.diet
    }

    fun updateData(animals: List<Animal>) {
        values = animals
        notifyDataSetChanged()
    }

}