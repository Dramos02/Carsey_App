package com.example.carsey_app

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.carsey_app.databinding.ItemBinding

class Adapter (val list:ArrayList<Info>):RecyclerView.Adapter<Adapter.MyView>() {

    inner class MyView(val itemBinding: ItemBinding):RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        return MyView(ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.itemBinding.imageView.setImageResource(list[position].image)
        holder.itemBinding.textView.text = list[position].name

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val itemName = list[position].name

            // Display a toast when the card is clicked
            Toast.makeText(context,"Carsey gives you $itemName", Toast.LENGTH_SHORT).show()

            val intent = Intent(context, BrandDetail::class.java)
            intent.putExtra("brandName", itemName)
            context.startActivity(intent)

        }
    }

}