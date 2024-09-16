package com.kawunus.mythings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kawunus.mythings.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView = binding.recyclewView
        val placesList = listOf(
            Place("гараж", 3),
            Place("балкон", 29),
            Place("кухня", 15),
            Place("гостиная", 7),
            Place("спальня", 5),
            Place("ванная", 1),
            Place("коридор", 12),
            Place("кладовка", 18),
            Place("чердак", 24)
        )
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = PlacesAdapter()
        recyclerView.adapter = adapter

        (recyclerView.adapter as PlacesAdapter).saveData(placesList)
    }
}