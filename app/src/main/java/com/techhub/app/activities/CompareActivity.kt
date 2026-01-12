package com.techhub.app.activities

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.techhub.app.R
import com.techhub.app.databinding.ActivityCompareBinding
import com.techhub.app.models.Smartphone
import com.techhub.app.models.SmartphoneData

class CompareActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityCompareBinding
    private var phone1: Smartphone? = null
    private var phone2: Smartphone? = null
    private val smartphones = SmartphoneData.getAllSmartphones()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompareBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupToolbar()
        setupSpinners()
    }
    
    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Bandingkan Smartphone"
        }
    }
    
    private fun setupSpinners() {
        val phoneNames = listOf("Pilih Smartphone") + smartphones.map { "${it.brand} ${it.name}" }
        
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, phoneNames)
        
        // Setup Spinner 1
        binding.spinnerPhone1.adapter = adapter
        binding.spinnerPhone1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                phone1 = if (position > 0) smartphones[position - 1] else null
                updateComparison()
            }
            
            override fun onNothingSelected(parent: AdapterView<*>?) {
                phone1 = null
                updateComparison()
            }
        }
        
        // Setup Spinner 2
        binding.spinnerPhone2.adapter = adapter
        binding.spinnerPhone2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                phone2 = if (position > 0) smartphones[position - 1] else null
                updateComparison()
            }
            
            override fun onNothingSelected(parent: AdapterView<*>?) {
                phone2 = null
                updateComparison()
            }
        }
    }
    
    private fun updateComparison() {
        if (phone1 != null && phone2 != null) {
            binding.comparisonLayout.visibility = View.VISIBLE
            binding.emptyStateLayout.visibility = View.GONE
            displayComparison()
        } else {
            binding.comparisonLayout.visibility = View.GONE
            binding.emptyStateLayout.visibility = View.VISIBLE
        }
    }
    
    private fun displayComparison() {
        phone1?.let { p1 ->
            binding.apply {
                // Phone 1
                Glide.with(this@CompareActivity)
                    .load(p1.imageUrl)
                    .placeholder(R.drawable.placeholder_phone)
                    .into(ivPhone1)
                tvBrand1.text = p1.brand
                tvName1.text = p1.name
                tvPrice1.text = p1.price
                tvProcessor1.text = p1.processor
                tvDisplay1.text = p1.display
                tvCamera1.text = p1.camera
                tvBattery1.text = p1.battery
                tvRam1.text = p1.ram
                tvStorage1.text = p1.storage
                tvOs1.text = p1.os
                tvYear1.text = p1.releaseYear.toString()
            }
        }
        
        phone2?.let { p2 ->
            binding.apply {
                // Phone 2
                Glide.with(this@CompareActivity)
                    .load(p2.imageUrl)
                    .placeholder(R.drawable.placeholder_phone)
                    .into(ivPhone2)
                tvBrand2.text = p2.brand
                tvName2.text = p2.name
                tvPrice2.text = p2.price
                tvProcessor2.text = p2.processor
                tvDisplay2.text = p2.display
                tvCamera2.text = p2.camera
                tvBattery2.text = p2.battery
                tvRam2.text = p2.ram
                tvStorage2.text = p2.storage
                tvOs2.text = p2.os
                tvYear2.text = p2.releaseYear.toString()
            }
        }
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
