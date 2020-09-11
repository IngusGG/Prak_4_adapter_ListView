package com.example.prak_4_adapter_listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    private val items = mutableListOf(
        "Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb", "Ice Cream Sandwich",
        "Jelly Bean", "KitKat", "Lollipop", "Marshmallow", "Nougat", "Oreo", "Pie", "10", "11")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        // definējam adapteri, kuru izmantojam, lai parādītu sarakstu ar definētajām vērtībām
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)

        // pietiktu tikai ar šo, lai izvadītu sarakstu
        mainItems.adapter = adapter


        // ja tiek noklikšķināts uz jebkura no mainItema
        mainItems.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, items[position], Toast.LENGTH_SHORT).show()
        }

        // ja noklikšķina uz pogas, tiks pievienota klāt jauns ieraksts
        mainButtonAdd2.setOnClickListener {
            items.add(mainEditAdd2.text.toString())
                // pēc elementa pievienošanas, adapterim nepieciešams tos pārskatīt un pārzīmēt
                adapter.notifyDataSetChanged()
        }
    }
}