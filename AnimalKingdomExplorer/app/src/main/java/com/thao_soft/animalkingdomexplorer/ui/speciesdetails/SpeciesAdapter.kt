package com.thao_soft.animalkingdomexplorer.ui.speciesdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thao_soft.animalkingdomexplorer.data.model.Species
import com.thao_soft.animalkingdomexplorer.databinding.FragmentSpeciesItemBinding

class SpeciesAdapter(
    private var values: List<Species>
) : RecyclerView.Adapter<SpeciesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentSpeciesItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.name.text = item.name
        holder.description.text = item.description
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentSpeciesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val name: TextView = binding.name
        val description: TextView = binding.description
    }

    fun updateData(species: List<Species>) {
        values = species
        notifyDataSetChanged()
    }

}