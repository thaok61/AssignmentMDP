package com.thao_soft.sportnewsandinformation.fragments.events_fragment

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

import com.thao_soft.sportnewsandinformation.fragments.events_fragment.placeholder.EventContent.EventItem
import com.thao_soft.sportnewsandinformation.databinding.FragmentEventItemBinding

/**
 * [RecyclerView.Adapter] that can display a [EventItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyEventRecyclerViewAdapter(
    private val values: List<EventItem>
) : RecyclerView.Adapter<MyEventRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentEventItemBinding.inflate(
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
        holder.date.text = item.date
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentEventItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val name: TextView = binding.eventName
        val description: TextView = binding.description
        val date: TextView = binding.eventDate
    }

}