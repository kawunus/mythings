package com.kawunus.mythings.ui.adapter.things

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kawunus.mythings.databinding.ThingItemBinding
import com.kawunus.mythings.model.Thing
import com.kawunus.mythings.util.ImageConverter

class ThingViewHolder(thingView: View) : ViewHolder(thingView) {

    private val binding: ThingItemBinding = ThingItemBinding.bind(thingView)
    fun bind(model: Thing) = with(binding) {
        thingTextView.text = model.name
        imageView.setImageBitmap(ImageConverter.byteArrayToBitmap(model.image))
    }
}