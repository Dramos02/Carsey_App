package com.example.carsey_app

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.Color.parseColor
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.carsey_app.databinding.ActivityShoppingCartBinding
import com.google.android.material.snackbar.Snackbar

class ShoppingCart : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityShoppingCartBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.backBtn.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)

            startActivity(intent)
            this.finish()
        }

        //Set the cart buttons which car to be selected
        binding.cartBtn1.setOnClickListener {
            if (binding.cartBtn1.isChecked) {
                binding.cartImg.setImageResource(R.drawable.mazda2)
                val message = "You selected Mazda 2"
                val snackbar = Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT)
                snackbar.setAction("Close") {
                    snackbar.dismiss()
                }
                snackbar.show()

                binding.cartBtn2.isChecked = false
                binding.cartBtn3.isChecked = false
            }else{
                binding.cartBtn1.isChecked = true
            }

        }

        binding.cartBtn2.setOnClickListener {
            if (binding.cartBtn2.isChecked) {
                binding.cartImg.setImageResource(R.drawable.mazda5)
                val message = "You selected Mazda MX-5"
                val snackbar = Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT)
                snackbar.setAction("Close") {
                    snackbar.dismiss()
                }
                snackbar.show()

                binding.cartBtn1.isChecked = false
                binding.cartBtn3.isChecked = false
            }else{
                binding.cartBtn2.isChecked = true
            }

        }

        binding.cartBtn3.setOnClickListener {
            if (binding.cartBtn3.isChecked) {
                binding.cartImg.setImageResource(R.drawable.venom)
                val message = "You selected Hennessey Venom"
                val snackbar = Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT)
                snackbar.setAction("Close") {
                    snackbar.dismiss()
                }
                snackbar.show()

                binding.cartBtn1.isChecked = false
                binding.cartBtn2.isChecked = false
            }else{
                binding.cartBtn3.isChecked = true
            }

        }


        //Set the car color buttons

        binding.defColorBtn.setOnClickListener {
            binding.defColorBtn.setBackgroundColor(Color.GRAY)
            binding.blueColorBtn.setBackgroundColor(parseColor("#FF6200ED"))

            if (binding.cartBtn1.isChecked) {
                Toast.makeText(this, "You selected car color to Default", Toast.LENGTH_SHORT).show()
                binding.cartImg.setImageResource(R.drawable.mazda2)

            }else if (binding.cartBtn2.isChecked){
                Toast.makeText(this, "You selected car color to Default", Toast.LENGTH_SHORT).show()
                binding.cartImg.setImageResource(R.drawable.mazda5)

            }else if (binding.cartBtn3.isChecked){
                Toast.makeText(this, "You selected car color to Default", Toast.LENGTH_SHORT).show()
                binding.cartImg.setImageResource(R.drawable.venom)
            }

        }

        binding.blueColorBtn.setOnClickListener {
            binding.blueColorBtn.setBackgroundColor(Color.BLUE)
            binding.defColorBtn.setBackgroundColor(parseColor("#FF6200ED"))
            if (binding.cartBtn1.isChecked) {
                Toast.makeText(this, "You selected car color to Blue", Toast.LENGTH_SHORT).show()
                binding.cartImg.setImageResource(R.drawable.mazda2b)

            }else if (binding.cartBtn2.isChecked){
                Toast.makeText(this, "You selected car color to Blue", Toast.LENGTH_SHORT).show()
                binding.cartImg.setImageResource(R.drawable.mazda5b)

            }else if (binding.cartBtn3.isChecked){
                Toast.makeText(this, "You selected car color to Blue", Toast.LENGTH_SHORT).show()
                binding.cartImg.setImageResource(R.drawable.venomb)
            }


        }


        //Check out proceed verification
        binding.proceedBtn.setOnClickListener {
            // Create an AlertDialog
            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setMessage("Do you want to checkout your car?")
                .setPositiveButton("Yes") { dialog, which ->
                    // Handle "Yes" button click
                    val message = "Still on Beta!!"
                    val snackbar = Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT)
                    snackbar.setAction("Close") {
                        snackbar.dismiss()
                    }
                    snackbar.show()

                    // Implement your checkout logic here
                }
                .setNegativeButton("No") { dialog, which ->
                    // Handle "No" button click
                    // Close the dialog or perform any desired action
                }

            // Create and show the AlertDialog
            val alertDialog = alertDialogBuilder.create()
            alertDialog.setTitle("Checkout")
            alertDialog.show()
        }
    }
}