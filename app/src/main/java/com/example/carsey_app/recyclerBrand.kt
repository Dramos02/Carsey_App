package com.example.carsey_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carsey_app.databinding.ActivityRecyclerBrandBinding

class recyclerBrand : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerBrandBinding
    private lateinit var adapter: Adapter
    private lateinit var list: ArrayList <Info>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBrandBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.setHasFixedSize(true)

        list = ArrayList()
        list.add(Info(R.drawable.mercedes, "MERCEDES"))
        list.add(Info(R.drawable.astonm, "ASTON MARTIN"))
        list.add(Info(R.drawable.audi, "AUDI"))
        list.add(Info(R.drawable.chevrolet, "CHEVROLET"))
        list.add(Info(R.drawable.dodge, "DODGE"))
        list.add(Info(R.drawable.ferrari, "FERRARI"))
        list.add(Info(R.drawable.hyundai, "HYUNDAI"))
        list.add(Info(R.drawable.lamborghini, "LAMBORGHINI"))
        list.add(Info(R.drawable.mazda, "MAZDA"))
        list.add(Info(R.drawable.mitsubishi, "MITSUBISHI"))
        list.add(Info(R.drawable.porsche, "PORSCHE"))
        list.add(Info(R.drawable.tesla, "TESLA"))

        adapter = Adapter(list)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager (this)


        binding.mainMenuBtn.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)

            startActivity(intent)
            this.finish()
        }

    }
}