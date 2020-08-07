package com.choala.rickandmortyallinfo.characterList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.choala.domain.model.CharacterLite
import com.choala.rickandmortyallinfo.R
import kotlinx.android.synthetic.main.item_character.view.*

class CharactersListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(character: CharacterLite) {
        with(itemView) {
            tv_character_name.text = character.name
            iv_character_head.load(character.url) {
                placeholder(R.drawable.rick_placeholder)
            }
        }
    }

    init {
    }

    companion object {
        fun create(parent: ViewGroup): CharactersListViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_character, parent, false)
            return CharactersListViewHolder(view)
        }
    }
}