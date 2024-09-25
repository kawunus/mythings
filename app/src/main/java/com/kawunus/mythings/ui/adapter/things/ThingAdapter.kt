package com.kawunus.mythings.ui.adapter.things

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.kawunus.mythings.R
import com.kawunus.mythings.model.Thing

class ThingAdapter : Adapter<ThingViewHolder>() {

    private val diffUtil = object : DiffUtil.ItemCallback<Thing>() {
        override fun areItemsTheSame(oldItem: Thing, newItem: Thing): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Thing, newItem: Thing): Boolean {
            return oldItem == newItem
        }

    }

    private val asyncListDiffer = AsyncListDiffer(this, diffUtil)

    fun saveData(thingList: List<Thing>) {
        asyncListDiffer.submitList(thingList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.place_item, parent, false)
        return ThingViewHolder(view)
    }

    override fun getItemCount() = asyncListDiffer.currentList.size

    override fun onBindViewHolder(holder: ThingViewHolder, position: Int) {
        holder.bind(asyncListDiffer.currentList[position])
    }
}