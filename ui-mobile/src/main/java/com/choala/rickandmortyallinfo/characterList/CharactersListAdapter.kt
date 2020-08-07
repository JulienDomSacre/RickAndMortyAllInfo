package com.choala.rickandmortyallinfo.characterList

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.choala.domain.model.CharacterLite

class CharactersListAdapter(val onClick: (CharacterLite?) -> Unit) :
    PagingDataAdapter<CharacterLite, RecyclerView.ViewHolder>(REPO_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CharactersListViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val repoItem = getItem(position)
        if (repoItem != null) {
            (holder as CharactersListViewHolder).bind(repoItem)
            holder.itemView.setOnClickListener { onClick(getItem(position)) }
        }
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<CharacterLite>() {
            override fun areItemsTheSame(
                oldItem: CharacterLite,
                newItem: CharacterLite
            ): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(
                oldItem: CharacterLite,
                newItem: CharacterLite
            ): Boolean =
                oldItem == newItem
        }
    }
}