package com.thao_soft.sportnewsandinformation.fragments.athletes_fragment

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

import com.thao_soft.sportnewsandinformation.fragments.athletes_fragment.placeholder.AthleteContent.AthleteItem
import com.thao_soft.sportnewsandinformation.databinding.FragmentAtheleteItemBinding

/**
 * [RecyclerView.Adapter] that can display a [AthleteItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyAthletesRecyclerViewAdapter(
    private val values: List<AthleteItem>
) : RecyclerView.Adapter<MyAthletesRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentAtheleteItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.athleteName.text = item.athleteName
        holder.sportName.text = item.sportName
        holder.country.text = item.country
        holder.bestPerformance.text = item.bestPerformance
        holder.medals.text = item.medals
        holder.facts.text = item.facts
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentAtheleteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val athleteName: TextView = binding.athleteName
        val sportName: TextView = binding.sportName
        val country: TextView = binding.country
        val bestPerformance: TextView = binding.bestPerformance
        val medals: TextView = binding.medals
        val facts: TextView = binding.facts
    }

}