package com.example.prak_4_adapter_listview

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycle_view.*


class RecycleViewActivity : AppCompatActivity() {

    // ar CTRLS uzejot virsū parādīs no kā sastāv (elementus)
    private val shoppingItems = mutableListOf(
        ShoppingItem("Milk", 1, "l"),
        ShoppingItem("Bread", 1, "pcs."),
        ShoppingItem("Potatoes", 2, "kg"),
        ShoppingItem("Eggs", 12, "pcs.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)

        // Vertīkālā scrollēšana
        // Priekš RecycleView jāpievienot ..Linear Layout.. manager.
        // to var darīt arī XML --> app:layoutManager="android.recycleview.widget.LinearLayoutManager"
        mainItems.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // sakārtojam sākotnējās vērtības
        shoppingItems.sortBy { it.name.toLowerCase() }

        val adapter = ShoppingItemRecyclerAdapter(shoppingItems)
        mainItems.adapter = adapter

        // radio buttons
        var radio = "kg"
        radioGroup.setOnCheckedChangeListener { group, checkedID ->
            if(checkedID == R.id.radio1)
                radio = radio1.text.toString()
            if(checkedID == R.id.radio2)
                radio = radio2.text.toString()
            if(checkedID == R.id.radio3)
                radio = radio3.text.toString()
        }

        // vēlviena elementa pievienošana
        mainButtonAdd.setOnClickListener {

            // ja ir tukšums pie daudzuma, tad 0
            val countItems: String
            if (maincCountAdd.text.toString() == "") {countItems = "0"} else {countItems = maincCountAdd.text.toString()}

            // elementa pievienošana
            shoppingItems.add(
                ShoppingItem(
                    if(mainEditAdd.text.toString() == ""){"empty"}else{mainEditAdd.text.toString()},
                   //mainEditAdd.text.toString(),
                    countItems.toInt(),
                    //maincCountAdd.text.toString().toInt(),
                    radio.toString()
                )
            )

            // listu sakārtōjot pēc pirmās kolonnas (ielikts, lai visi burti tiek uzskatīti kā mazie burti - pretēji BB ir lielāks par aa)
            shoppingItems.sortBy { it.name.toLowerCase() }

            // pēc datu ievades teksts un pievienošanas, ievadītais teksts no ievades loga pazūd
            mainEditAdd.setText("")
            maincCountAdd.setText("")

            // tiek atjaunots saraksts
            adapter.notifyDataSetChanged()

        }
    }
}