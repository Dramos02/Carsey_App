package com.example.carsey_app

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.carsey_app.databinding.ActivityCarTypesBinding

class CarTypes : AppCompatActivity() {

    private val textList = ArrayList<String>()
    private val imageList = ArrayList<Int>()
    private lateinit var binding: ActivityCarTypesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarTypesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainMenuBtn3.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
            this.finish()
        }

        fillArrays()

        val adapter = GridAdapter(textList, imageList)
        binding.gridView.adapter = adapter

        binding.gridView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                applicationContext,
                "The type of car is ${textList[position]}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    private fun fillArrays() {
        textList.add("SUV")
        textList.add("HATCHBACK")
        textList.add("SEDAN")
        textList.add("COUPE")
        textList.add("STATION WAGON")
        textList.add("CONVERTIBLE")
        textList.add("CROSSOVER")
        textList.add("MINIVAN")
        textList.add("SPORTS CAR")
        textList.add("COMPACT CAR")
        textList.add("PICKUP TRUCK")
        textList.add("VAN")
        textList.add("SUPERCAR")
        // Add other items here...

        imageList.add(R.drawable.suv)
        imageList.add(R.drawable.hatchback)
        imageList.add(R.drawable.sedan)
        imageList.add(R.drawable.coupe)
        imageList.add(R.drawable.stationw)
        imageList.add(R.drawable.convertible)
        imageList.add(R.drawable.crossover)
        imageList.add(R.drawable.minivan)
        imageList.add(R.drawable.sports)
        imageList.add(R.drawable.compact)
        imageList.add(R.drawable.pickup)
        imageList.add(R.drawable.van)
        imageList.add(R.drawable.supercar)

        // Add other images here...
    }
}