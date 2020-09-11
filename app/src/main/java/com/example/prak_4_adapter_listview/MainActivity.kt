package com.example.prak_4_adapter_listview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_shopping.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. images
        btn1.setOnClickListener {
            val intent = Intent(this, ScrollViewActivity::class.java)
            startActivity(intent)
            Toast.makeText(this,"ScrollView!", Toast.LENGTH_SHORT).show()
        }

        // 2. list
        btn2.setOnClickListener {
            val intent = Intent(this, ListViewActivity::class.java)
            startActivity(intent)
            Toast.makeText(this,"ListView!", Toast.LENGTH_SHORT).show()
        }

        // 3. grid
        btn3.setOnClickListener {
            val intent = Intent(this, GridViewActivity::class.java)
            startActivity(intent)
            Toast.makeText(this,"GridView!", Toast.LENGTH_SHORT).show()
        }

        // 4. recycle
        btn4.setOnClickListener {
            val intent = Intent(this, RecycleViewActivity::class.java)
            startActivity(intent)
            Toast.makeText(this,"RecycleView!", Toast.LENGTH_SHORT).show()
        }


    }
}





