package com.example.prak_4_adapter_listview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_shopping.view.*

class ShoppingItemRecyclerAdapter(private val items: MutableList<ShoppingItem>) :
    RecyclerView.Adapter<ShoppingItemRecyclerAdapter.ShoppingViewHolder>() {

    //// ViewHolder paredzēts ātrdarbībai, lai neveiktu meklēšanu katru reize, bet gan vienu reizi.
    //// Un nepieciešamības gadījumā datus iegūst no ViewHolder nevis meklē tos atkārtoti
    //// Aizņem minimāli vairāk atmiņas, bet ieekonomē uz ātrdarbību.

    // view holder class
    class ShoppingViewHolder(view: View) : RecyclerView.ViewHolder(view)

    // inflate layout and create view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_shopping, parent, false)
        return ShoppingViewHolder(view)
    }

    // need to return item count
    override fun getItemCount() = items.size

    // bind item to view holder
    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val item = items[position]
        val context = holder.itemView.context
        holder.itemView.shoppingName.text = item.name
        holder.itemView.shoppingQuantity.text = context.resources
            .getString(R.string.quantity_text, item.quantity, item.unit)

        holder.itemView.setOnClickListener {
            Toast.makeText(context, item.name, Toast.LENGTH_SHORT).show()
        }


        // ar krustiņu dzēšam
        holder.itemView.shoppingRemove.setOnClickListener {
            items.removeAt(position)
            notifyDataSetChanged()
            Toast.makeText(context, "removed", Toast.LENGTH_SHORT).show()
        }

    }
}