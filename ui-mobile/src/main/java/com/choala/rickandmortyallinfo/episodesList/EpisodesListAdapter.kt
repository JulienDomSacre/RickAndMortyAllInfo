package com.choala.rickandmortyallinfo.episodesList

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.choala.domain.model.EpisodeLite

class EpisodesListAdapter(val onClick: (EpisodeLite?) -> Unit) :
    PagingDataAdapter<EpisodeLite, RecyclerView.ViewHolder>(REPO_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return EpisodesListViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val repoItem = getItem(position)
        if (repoItem != null) {
            (holder as EpisodesListViewHolder).bind(repoItem)
            holder.itemView.setOnClickListener { onClick(getItem(position)) }
        }
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<EpisodeLite>() {
            override fun areItemsTheSame(
                oldItem: EpisodeLite,
                newItem: EpisodeLite
            ): Boolean = oldItem.name == newItem.name

            override fun areContentsTheSame(
                oldItem: EpisodeLite,
                newItem: EpisodeLite
            ): Boolean = oldItem == newItem
        }
    }
}