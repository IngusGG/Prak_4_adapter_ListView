package com.example.prak_4_adapter_listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_grid_view.*
import kotlinx.android.synthetic.main.activity_list_view.*
import kotlinx.android.synthetic.main.activity_list_view.mainItems


class GridViewActivity : AppCompatActivity() {

    private val items = mutableListOf(
        "Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb", "Ice Cream Sandwich",
        "Jelly Bean", "KitKat", "Lollipop", "Marshmallow", "Nougat", "Oreo", "Pie", "10", "11")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)

        mainItems2.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, items[position], Toast.LENGTH_SHORT).show()
        }

        mainItems2.adapter = adapter

    }
}