package com.example.carsey_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.carsey_app.databinding.ActivityBrandDetailBinding

class BrandDetail : AppCompatActivity() {

    private lateinit var binding: ActivityBrandDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBrandDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainMenuBtn2.setOnClickListener {
            var intent = Intent(this,recyclerBrand::class.java)

            startActivity(intent)
            this.finish()
        }
        val brandName = intent.getStringExtra("brandName")

        // Fetch brand details based on the brandName and update the UI
        val brandDescription =
            getBrandDescription(brandName) // Implement this function to get brand details
        //val brandImages = getBrandImages(brandName)
        val backgroundImage = getBackgroundImage(brandName)
        binding.brandDetailLayout.setBackgroundResource(backgroundImage)
        binding.brandName.text = brandName
        binding.brandDescription.text = brandDescription


    }
}
    private fun getBrandDescription(brandName: String?): String {
        return when (brandName) {
            "MERCEDES" -> "Mercedes-Benz is a German luxury automobile manufacturer " +
                    "known for producing high-quality cars."
            "ASTON MARTIN" -> "Aston Martin is a British luxury sports car manufacturer " +
                    "with a rich history in racing and style."
            "AUDI" -> "Audi is a German automobile manufacturer " +
                    "that specializes in premium vehicles."
            "CHEVROLET" -> "Chevrolet is an American automobile division of " +
                    "General Motors known for a wide range of vehicles."
            "DODGE" -> "Dodge is an American brand known for " +
                    "its muscle cars and performance vehicles."
            "FERRARI" -> "Ferrari is an Italian sports car manufacturer " +
                    "recognized for its iconic and powerful cars."
            "HYUNDAI" -> "Hyundai is a South Korean automaker " +
                    "offering a diverse range of vehicles."
            "LAMBORGHINI" -> "Lamborghini is an Italian manufacturer " +
                    "known for producing luxury sports cars."
            "MAZDA" -> "Mazda is a Japanese automaker known for " +
                    "its stylish and reliable vehicles."
            "MITSUBISHI" -> "Mitsubishi is a Japanese brand " +
                    "offering a variety of cars and SUVs."
            "PORSCHE" -> "Porsche is a German sports car manufacturer " +
                    "known for its performance-oriented vehicles."
            "TESLA" -> "Tesla is an American electric vehicle manufacturer " +
                    "known for its innovative electric cars."
            else -> "Description not available for $brandName" // Use a default description for unknown brands
        }
}

    private fun getBackgroundImage(brandName: String?): Int {
        return when (brandName) {
            "MERCEDES" -> R.drawable.mercedesbg
            "ASTON MARTIN" -> R.drawable.ambg
            "AUDI" -> R.drawable.audibg
            "CHEVROLET" -> R.drawable.chevroletbg
            "DODGE" -> R.drawable.dodgebg
            "FERRARI" -> R.drawable.ferraribg
            "HYUNDAI" -> R.drawable.hyundaibg
            "LAMBORGHINI" -> R.drawable.lambobg
            "MAZDA" -> R.drawable.mazdabg
            "MITSUBISHI" -> R.drawable.mitsuhizhibg
            "PORSCHE" -> R.drawable.porschebg
            "TESLA" -> R.drawable.teslabg
        else -> R.drawable.bg0 // Use a default background for unknown brands
    }
}