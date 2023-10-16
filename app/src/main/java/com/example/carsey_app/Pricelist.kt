package com.example.carsey_app

import android.R
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.carsey_app.databinding.ActivityPricelistBinding
import java.io.*
import java.text.DecimalFormat

class Pricelist : AppCompatActivity() {

    private lateinit var binding : ActivityPricelistBinding
    private var priceFormat: DecimalFormat = DecimalFormat("###,###,###.00")
    private lateinit var listView: ListView
    private lateinit var searchView: SearchView
    private var priceList = ArrayList<String>()
    private val fileName = "listinfo.dat"
    private var currentListSize:Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPricelistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listView = binding.listView
        searchView = binding.searchView

        binding.mainMenuBtn6.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
            this.finish()
        }

        binding.saveBtn.setOnClickListener {
            val carItemName = binding.carItemName.text
            val carPrice = binding.carItemPrice.text
            addTolist(carItemName,carPrice)
            currentListSize++
        }

        loadPriceList()
        updateListView()

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                filterListView(newText)
                return true
            }
        })

        listView.setOnItemClickListener {
                _, _, position, _ ->
            delDialog(position)
        }
    }
    private fun addTolist(carItemName: Editable, carPrice: Editable) {
        val item = carItemName.toString().trim().replaceFirstChar {it.uppercase()}
        val price = priceFormat.format(carPrice.toString().toFloat()).trim()

        val savedProd = "Car Name: $item \nCar Price: PHP $price"

        priceList.add(currentListSize, savedProd)

        carItemName.clear()
        carPrice.clear()

        updateListView()
        savePriceList()
    }
    private fun filterListView(query: String?) {
        if(query == null)
            return

        val filterList = priceList.filter { it.contains(query, true) }

        if(filterList.isEmpty())
            Toast.makeText(applicationContext,"No Item Found", Toast.LENGTH_LONG).show()
        else
            updateFilteredListView(filterList)
    }
    private fun updateFilteredListView(filterList: List<String>) {
        val updateAdapter = ArrayAdapter(this, R.layout.simple_list_item_1, filterList)
        listView.adapter = updateAdapter
    }
    private fun updateListView() {
        val updateAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, priceList)
        listView.adapter = updateAdapter
    }
    private fun savePriceList() {
        val outputStream: FileOutputStream
        try {
            outputStream = openFileOutput(fileName, Context.MODE_PRIVATE)
            val objOutputStream = ObjectOutputStream(outputStream)
            objOutputStream.writeObject(priceList)
            objOutputStream.close()
            outputStream.close()
        }
        catch (e: IOException) {
            e.printStackTrace()
        }
    }
    private fun loadPriceList() {
        val inputStream: FileInputStream
        try {
            inputStream = openFileInput(fileName)
            val objInputStream = ObjectInputStream(inputStream)
            val list = objInputStream.readObject() as ArrayList<*>
            priceList.addAll(list.filterIsInstance<String>())
            currentListSize = priceList.size
            objInputStream.close()
            inputStream.close()
        }
        catch(e: IOException) {
            e.printStackTrace()
        }
    }
    private fun delDialog(position: Int) {

        var posToDel = 0

        for(i in 0..priceList.size){
            if (listView.getItemAtPosition(position).toString() == priceList[i]) {
                break
            }
            posToDel++
        }

        val alert = AlertDialog.Builder(this)
        alert.setMessage("Would you like to delete this Car?")
        alert.setPositiveButton("Yes") {
                _ , _ ->
            priceList.removeAt(posToDel)
            currentListSize--
            updateListView()
            savePriceList()
        }
        alert.setNegativeButton("No") {
                dialog, _ ->
            dialog.cancel()
        }
        alert.create().show()
    }
}

