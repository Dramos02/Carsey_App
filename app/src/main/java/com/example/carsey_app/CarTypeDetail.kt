package com.example.carsey_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.carsey_app.databinding.ActivityCarTypeDetailBinding

class CarTypeDetail : AppCompatActivity() {
    private lateinit var binding: ActivityCarTypeDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCarTypeDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.mainMenuBtn4.setOnClickListener {
            var intent = Intent(this,CarTypes::class.java)

            startActivity(intent)
            this.finish()
        }

        val carType = intent.getStringExtra("carType")

        val carTypeDesc = getCarTyeDescription(carType)
        val carTypeImg = getBackgroundImage(carType)

        binding.carTypeTitle.text = carType
        binding.carTypeDescription.text = carTypeDesc
        binding.carTypeImg.setImageResource(carTypeImg)
    }
}

private fun getCarTyeDescription(carType: String?): String {
    return when (carType) {
        "SUV" -> "Sport Utility Vehicle - SUVs are known for their ." +
                "spacious interiors and off-road capabilities"
        "HATCHBACK" -> "Hatchbacks have a rear door that opens upwards" +
                " and are known for their compact size and practicality."
        "SEDAN" -> "Sedans are a popular car type with a separate " +
                "trunk compartment and comfortable seating for passengers."
        "COUPE" -> "Coupes are typically two-door cars with " +
                "a sporty design and a focus on performance."
        "STATION WAGON" -> "Station wagons offer extra cargo space and are " +
                "known for their versatility and family-friendly features."
        "CONVERTIBLE" -> "Convertibles have a retractable roof, " +
                "allowing you to enjoy open-air driving."
        "CROSSOVER" -> "Crossovers combine elements of SUVs and sedans, " +
                "offering a balance between style and utility."
        "MINIVAN" -> "Minivans are designed for families " +
                "and offer ample seating and cargo space."
        "SPORTS CAR" -> "Sports cars are built for speed and performance, " +
                "often with a focus on handling and acceleration."
        "COMPACT CAR" -> "Compact cars are small, " +
                "fuel-efficient vehicles suitable for urban driving."
        "PICKUP TRUCK" -> "Pickup trucks are known for their cargo beds " +
                "and towing capabilities, ideal for work and recreational use."
        "VAN" -> "Vans come in various sizes and " +
                "are used for transporting people or goods."
        "SUPERCAR" -> "Supercars are high-performance, exotic vehicles " +
                "designed for top speed and advanced engineering"
        else -> "Description not available for $carType" // Use a default description for unknown carType
    }
}

private fun getBackgroundImage(carType: String?): Int {
    return when (carType) {
        "SUV" -> R.drawable.suv
        "HATCHBACK" -> R.drawable.hatchback
        "SEDAN" -> R.drawable.sedan
        "COUPE" -> R.drawable.coupe
        "STATION WAGON" -> R.drawable.stationw
        "CONVERTIBLE" -> R.drawable.convertible
        "CROSSOVER" -> R.drawable.crossover
        "SPORTS CAR" -> R.drawable.sports
        "COMPACT CAR" -> R.drawable.compact
        "VAN" -> R.drawable.van
        "SUPERCAR" -> R.drawable.supercar
        "MINIVAN" -> R.drawable.minivan
        "PICKUP TRUCK" -> R.drawable.pickup
        else -> R.drawable.car // Use a default background for unknown brands
    }
}