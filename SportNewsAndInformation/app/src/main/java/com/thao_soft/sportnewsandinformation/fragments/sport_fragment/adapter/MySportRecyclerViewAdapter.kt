package com.thao_soft.sportnewsandinformation.fragments.sport_fragment.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

import com.thao_soft.sportnewsandinformation.fragments.sport_fragment.placeholder.SportContent.SportItem
import com.thao_soft.sportnewsandinformation.databinding.FragmentSportBinding

/**
 * [RecyclerView.Adapter] that can display a [SportItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MySportRecyclerViewAdapter(
    private val values: List<SportItem>
) : RecyclerView.Adapter<MySportRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentSportBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.sportType.text = item.type
        holder.sportName.text = item.name
        holder.instruction.text = item.instruction
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentSportBinding) : RecyclerView.ViewHolder(binding.root) {
        val sportType: TextView = binding.sportType
        val sportName: TextView = binding.sportName
        val instruction: TextView = binding.instruction
    }

}