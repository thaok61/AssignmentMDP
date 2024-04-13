package com.thao_soft.sportnewsandinformation.fragments.historical_archive_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thao_soft.sportnewsandinformation.databinding.FragmentHistoricalArchiveItemBinding
import com.thao_soft.sportnewsandinformation.fragments.historical_archive_fragment.placeholder.ArchiveContent.ArchiveItem

/**
 * [RecyclerView.Adapter] that can display a [ArchiveItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyHistoricalArchiveRecyclerViewAdapter(
    private val values: List<ArchiveItem>
) : RecyclerView.Adapter<MyHistoricalArchiveRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentHistoricalArchiveItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.historyName.text = item.name
        holder.historyDate.text = item.date
        holder.historyDescription.text = item.description
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentHistoricalArchiveItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val historyName: TextView = binding.historyName
        val historyDate: TextView = binding.historyDate
        val historyDescription: TextView = binding.historyDescription
    }

}