package com.techhub.app.activities

import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
import com.techhub.app.R
import com.techhub.app.databinding.ActivityDetailBinding
import com.techhub.app.models.Smartphone

class DetailActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityDetailBinding
    private lateinit var smartphone: Smartphone
    
    companion object {
        const val EXTRA_SMARTPHONE = "extra_smartphone"
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        // Ambil data smartphone dari Intent
        smartphone = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_SMARTPHONE, Smartphone::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_SMARTPHONE)
        } ?: run {
            finish()
            return
        }
        
        setupToolbar()
        displaySmartphoneDetails()
    }
    
    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = smartphone.name
        }
    }
    
    private fun displaySmartphoneDetails() {
        binding.apply {
            // Load image
            Glide.with(this@DetailActivity)
                .load(smartphone.imageUrl)
                .placeholder(R.drawable.placeholder_phone)
                .error(R.drawable.placeholder_phone)
                .centerCrop()
                .into(ivSmartphone)
            
            // Basic info
            tvBrand.text = smartphone.brand
            tvName.text = smartphone.name
            tvPrice.text = smartphone.price
            tvDescription.text = smartphone.description
            tvReleaseYear.text = "Rilis: ${smartphone.releaseYear}"
            
            // Specifications
            tvProcessor.text = smartphone.processor
            tvDisplay.text = smartphone.display
            tvCamera.text = smartphone.camera
            tvBattery.text = smartphone.battery
            tvRam.text = smartphone.ram
            tvStorage.text = smartphone.storage
            tvOs.text = smartphone.os
            
            // Colors
            chipGroupColors.removeAllViews()
            smartphone.colors.forEach { color ->
                val chip = Chip(this@DetailActivity).apply {
                    text = color
                    isClickable = false
                }
                chipGroupColors.addView(chip)
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
