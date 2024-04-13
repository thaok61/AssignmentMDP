package com.thao_soft.sportnewsandinformation.fragments.news_fragment

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

import com.thao_soft.sportnewsandinformation.databinding.FragmentNewsBinding
import com.thao_soft.sportnewsandinformation.fragments.news_fragment.placeholder.NewsContent

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyNewsRecyclerViewAdapter(
    private val values: List<NewsContent.NewsItem>
) : RecyclerView.Adapter<MyNewsRecyclerViewAdapter.ViewHolder>() {
    private var currentContext: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        currentContext = parent.context
        return ViewHolder(
            FragmentNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.title.text = item.title
        holder.description.text = item.description
        if (currentContext != null && item.url.isNotBlank()) {
            Glide.with(currentContext!!).load(item.url).into(holder.image)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        val image: ImageView = binding.imageNews
        val title: TextView = binding.title
        val description: TextView = binding.description
    }

}