package com.example.carsey_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.carsey_app.databinding.GridviewLayoutBinding


class GridAdapter (private val textList: ArrayList<String>, private val imageList: ArrayList<Int>) : BaseAdapter(){
    override fun getCount(): Int {
        return textList.size
    }

    override fun getItem(position: Int): Any {
        return textList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding = GridviewLayoutBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        val imageView = binding.imageView
        val textView = binding.textView

        textView.text = textList[position]
        imageView.setImageResource(imageList[position])

        return binding.root
    }


}