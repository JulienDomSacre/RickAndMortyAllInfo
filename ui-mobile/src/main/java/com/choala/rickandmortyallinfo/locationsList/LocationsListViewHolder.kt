package com.choala.rickandmortyallinfo.locationsList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.choala.domain.model.LocationLite
import com.choala.rickandmortyallinfo.R
import kotlinx.android.synthetic.main.item_location.view.*

class LocationsListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(location: LocationLite) {
        with(itemView) {
            tv_itemLocation_name.text = location.name
        }
    }

    companion object {
        fun create(parent: ViewGroup): LocationsListViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_location, parent, false)
            return LocationsListViewHolder(view)
        }
    }
}