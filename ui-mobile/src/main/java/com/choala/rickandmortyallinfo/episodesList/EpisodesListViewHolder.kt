package com.choala.rickandmortyallinfo.episodesList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.choala.domain.model.EpisodeLite
import com.choala.rickandmortyallinfo.R
import kotlinx.android.synthetic.main.item_episode.view.*

class EpisodesListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(episode: EpisodeLite) {
        with(itemView) {
            tv_item_episode_name.text = episode.name
        }
    }


    companion object {
        fun create(parent: ViewGroup): EpisodesListViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_episode, parent, false)
            return EpisodesListViewHolder(view)
        }
    }
}