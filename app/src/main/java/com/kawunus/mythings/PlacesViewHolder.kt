package com.kawunus.mythings

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kawunus.mythings.databinding.PlaceItemBinding

class PlacesViewHolder(placeView: View) : RecyclerView.ViewHolder(placeView) {

    private val binding: PlaceItemBinding = PlaceItemBinding.bind(placeView)
    fun bind(model: Place) = with(binding) {
        placeTextView.text = model.name
        val count = model.countOfElements
        countOfThingsTextView.text = "$count ${
            WordEndingHelper.getWordForm(
                count,
                itemView.context.getString(R.string.place_form1),
                itemView.context.getString(R.string.place_form2),
                itemView.context.getString(R.string.place_form3)
            )
        }"
    }

}