package com.example.carsey_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.carsey_app.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Set the button to got shopping cart
        binding.imgTitle.setOnClickListener {
           var intent = Intent(this,ShoppingCart::class.java)

            startActivity(intent)
            this.finish()
        }

        //Set of checkButtons to change the background
        binding.bg1ChckX.setOnClickListener {
            if (binding.bg1ChckX.isChecked) {
                // Set background resource when bg1ChckX is checked
                binding.carseyApp.setBackgroundResource(R.drawable.bg1)

                // Uncheck other checkboxes
                binding.bg2ChckX.isChecked = false
                binding.bg3ChckX.isChecked = false
            } else {
                // Toggle the checkbox state
                binding.bg1ChckX.isChecked = true
            }
        }

        binding.bg2ChckX.setOnClickListener {
            if (binding.bg2ChckX.isChecked) {
                // Set background resource when bg1ChckX is checked
                binding.carseyApp.setBackgroundResource(R.drawable.bg2)

                // Uncheck other checkboxes
                binding.bg1ChckX.isChecked = false
                binding.bg3ChckX.isChecked = false
            } else {
                // Toggle the checkbox state
                binding.bg2ChckX.isChecked = true
            }
        }

        binding.bg3ChckX.setOnClickListener {
            if (binding.bg3ChckX.isChecked) {
                // Set background resource when bg1ChckX is checked
                binding.carseyApp.setBackgroundResource(R.drawable.bg3)

                // Uncheck other checkboxes
                binding.bg1ChckX.isChecked = false
                binding.bg2ChckX.isChecked = false
            } else {
                // Toggle the checkbox state
                binding.bg3ChckX.isChecked = true
            }
        }

        //Set of radioButtons and Imageview to display the car information and car picture

        binding.car1Btn.setOnClickListener {
            if (binding.car1Btn.isChecked) {
                binding.mainImgView.setImageResource(R.drawable.mazda2)
                binding.modelDescTxt.setText("Mazda 2 Sedan")
                binding.engineDescTxt.setText("1.5-liter Skyactiv-G")
                binding.priceDescTxt.setText("P 955,000")
                binding.transTypeDescTxt.setText("Automatic T / AT")

                binding.car2Btn.isChecked = false
                binding.car3Btn.isChecked = false
                binding.car4Btn.isChecked = false
                binding.car5Btn.isChecked = false
                binding.car6Btn.isChecked = false
                binding.car7Btn.isChecked = false
                binding.car8Btn.isChecked = false
            } else {
                binding.car1Btn.isChecked = true
            }
        }

        binding.car2Btn.setOnClickListener {
            if (binding.car2Btn.isChecked) {
                binding.mainImgView.setImageResource(R.drawable.mazda5)
                binding.modelDescTxt.setText("Mazda MX-5 RF")
                binding.engineDescTxt.setText("4-liter Skyactiv-G 4C")
                binding.priceDescTxt.setText("P 2,350,000")
                binding.transTypeDescTxt.setText("AT/MT")

                binding.car1Btn.isChecked = false
                binding.car3Btn.isChecked = false
                binding.car4Btn.isChecked = false
                binding.car5Btn.isChecked = false
                binding.car6Btn.isChecked = false
                binding.car7Btn.isChecked = false
                binding.car8Btn.isChecked = false
            } else {
                binding.car2Btn.isChecked = true
            }
        }

        binding.car3Btn.setOnClickListener {
            if (binding.car3Btn.isChecked) {
                binding.mainImgView.setImageResource(R.drawable.viper)
                binding.modelDescTxt.setText("Dodge Viper ACR")
                binding.engineDescTxt.setText("8-Liter Viper V10")
                binding.priceDescTxt.setText("P 8,249,055")
                binding.transTypeDescTxt.setText("Manual T / MT")

                binding.car1Btn.isChecked = false
                binding.car2Btn.isChecked = false
                binding.car4Btn.isChecked = false
                binding.car5Btn.isChecked = false
                binding.car6Btn.isChecked = false
                binding.car7Btn.isChecked = false
                binding.car8Btn.isChecked = false
            } else {
                binding.car3Btn.isChecked = true
            }
        }

        binding.car4Btn.setOnClickListener {
            if (binding.car4Btn.isChecked) {
                binding.mainImgView.setImageResource(R.drawable.chevelle)
                binding.modelDescTxt.setText("Chevrolet Chevelle")
                binding.engineDescTxt.setText("6.5-Liter Big-Block V8")
                binding.priceDescTxt.setText("P 1,000,000")
                binding.transTypeDescTxt.setText("AT / MT")

                binding.car1Btn.isChecked = false
                binding.car2Btn.isChecked = false
                binding.car3Btn.isChecked = false
                binding.car5Btn.isChecked = false
                binding.car6Btn.isChecked = false
                binding.car7Btn.isChecked = false
                binding.car8Btn.isChecked = false
            } else {
                binding.car4Btn.isChecked = true
            }
        }

        binding.car5Btn.setOnClickListener {
            if (binding.car5Btn.isChecked) {
                binding.mainImgView.setImageResource(R.drawable.venom)
                binding.modelDescTxt.setText("Hennessey Venom")
                binding.engineDescTxt.setText("7-Liter twin-turbocharged V8")
                binding.priceDescTxt.setText("P 79,338,000")
                binding.transTypeDescTxt.setText("Manual T / MT")

                binding.car1Btn.isChecked = false
                binding.car2Btn.isChecked = false
                binding.car3Btn.isChecked = false
                binding.car4Btn.isChecked = false
                binding.car6Btn.isChecked = false
                binding.car7Btn.isChecked = false
                binding.car8Btn.isChecked = false
            } else {
                binding.car5Btn.isChecked = true
            }
        }

        binding.car6Btn.setOnClickListener {
            if (binding.car6Btn.isChecked) {
                binding.mainImgView.setImageResource(R.drawable.gt3_296)
                binding.modelDescTxt.setText("Ferrari 296 GT3")
                binding.engineDescTxt.setText("6-Liter  GDI Turbo V6")
                binding.priceDescTxt.setText("P 34,852,050")
                binding.transTypeDescTxt.setText("Automatic T / AT")

                binding.car1Btn.isChecked = false
                binding.car2Btn.isChecked = false
                binding.car3Btn.isChecked = false
                binding.car4Btn.isChecked = false
                binding.car5Btn.isChecked = false
                binding.car7Btn.isChecked = false
                binding.car8Btn.isChecked = false
            } else {
                binding.car6Btn.isChecked = true
            }
        }

        binding.car7Btn.setOnClickListener {
            if (binding.car7Btn.isChecked) {
                binding.mainImgView.setImageResource(R.drawable.gts_812)
                binding.modelDescTxt.setText("Ferrari 812 Superfast")
                binding.engineDescTxt.setText("6.5-Liter  F140 GA V12")
                binding.priceDescTxt.setText("P 24,934,800")
                binding.transTypeDescTxt.setText("Automatic T / AT")

                binding.car1Btn.isChecked = false
                binding.car2Btn.isChecked = false
                binding.car3Btn.isChecked = false
                binding.car4Btn.isChecked = false
                binding.car5Btn.isChecked = false
                binding.car6Btn.isChecked = false
                binding.car8Btn.isChecked = false
            } else {
                binding.car7Btn.isChecked = true
            }
        }

        binding.car8Btn.setOnClickListener {
            if (binding.car8Btn.isChecked) {
                binding.mainImgView.setImageResource(R.drawable.aperta)
                binding.modelDescTxt.setText("LaFerrai Aperta")
                binding.engineDescTxt.setText("6-Liter  F140 GA Injected V12")
                binding.priceDescTxt.setText("P 396,690,000")
                binding.transTypeDescTxt.setText("Automatic T / AT")

                binding.car1Btn.isChecked = false
                binding.car2Btn.isChecked = false
                binding.car3Btn.isChecked = false
                binding.car4Btn.isChecked = false
                binding.car5Btn.isChecked = false
                binding.car6Btn.isChecked = false
                binding.car7Btn.isChecked = false
            } else {
                binding.car8Btn.isChecked = true
            }
        }
    }
}