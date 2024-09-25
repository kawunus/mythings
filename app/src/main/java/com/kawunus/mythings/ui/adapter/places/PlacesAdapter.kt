package com.kawunus.mythings.ui.adapter.places

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kawunus.mythings.R
import com.kawunus.mythings.model.Place

class PlacesAdapter : RecyclerView.Adapter<PlacesViewHolder>() {

    private val diffUtil = object : DiffUtil.ItemCallback<Place>() {
        override fun areItemsTheSame(oldItem: Place, newItem: Place): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Place, newItem: Place): Boolean {
            return oldItem == newItem
        }

    }

    private val asyncListDiffer = AsyncListDiffer(this, diffUtil)

    fun saveData(placeList: List<Place>) {
        asyncListDiffer.submitList(placeList)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlacesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.place_item, parent, false)
        return PlacesViewHolder(view)
    }

    override fun getItemCount() = asyncListDiffer.currentList.size

    override fun onBindViewHolder(holder: PlacesViewHolder, position: Int) {
        holder.bind(asyncListDiffer.currentList[position])
    }

}