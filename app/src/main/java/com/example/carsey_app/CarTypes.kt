package com.example.carsey_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.carsey_app.databinding.ActivityCarTypesBinding

class CarTypes : AppCompatActivity() {

    private lateinit var binding: ActivityCarTypesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarTypesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainMenuBtn3.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)

            startActivity(intent)
            this.finish()
        }
    }
}