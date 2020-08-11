package com.choala.rickandmortyallinfo.locationsList

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.choala.domain.model.LocationLite

class LocationsListAdapter(val onClick: (LocationLite?) -> Unit) :
    PagingDataAdapter<LocationLite, RecyclerView.ViewHolder>(REPO_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return LocationsListViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val repoItem = getItem(position)
        if (repoItem != null) {
            (holder as LocationsListViewHolder).bind(repoItem)
            holder.itemView.setOnClickListener { onClick(getItem(position)) }
        }
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<LocationLite>() {
            override fun areItemsTheSame(
                oldItem: LocationLite,
                newItem: LocationLite
            ): Boolean = oldItem.name == newItem.name

            override fun areContentsTheSame(
                oldItem: LocationLite,
                newItem: LocationLite
            ): Boolean = oldItem == newItem
        }
    }
}