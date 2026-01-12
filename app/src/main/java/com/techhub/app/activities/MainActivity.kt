package com.techhub.app.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.chip.Chip
import com.techhub.app.R
import com.techhub.app.adapters.SmartphoneAdapter
import com.techhub.app.databinding.ActivityMainBinding
import com.techhub.app.models.Smartphone
import com.techhub.app.models.SmartphoneData

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    private lateinit var smartphoneAdapter: SmartphoneAdapter
    private var currentBrand: String = "All"
    private var username: String = ""
    
    companion object {
        const val EXTRA_USERNAME = "extra_username"
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        // Terima data username dari Intent (dari LoginActivity atau RegisterActivity)
        username = intent.getStringExtra(EXTRA_USERNAME) ?: "User"
        
        setupToolbar()
        setupRecyclerView()
        setupBrandFilter()
        updateWelcomeText()
    }
    
    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "TechHub"
    }
    
    private fun updateWelcomeText() {
        binding.tvWelcome.text = "Selamat datang, $username"
    }
    
    private fun setupRecyclerView() {
        smartphoneAdapter = SmartphoneAdapter { smartphone ->
            navigateToDetail(smartphone)
        }
        
        binding.rvSmartphones.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = smartphoneAdapter
        }
        
        loadSmartphones()
    }
    
    private fun setupBrandFilter() {
        val brands = listOf("All") + SmartphoneData.getAllBrands()
        
        binding.chipGroupBrands.removeAllViews()
        brands.forEach { brand ->
            val chip = Chip(this).apply {
                text = brand
                isCheckable = true
                isChecked = brand == "All"
                setOnClickListener {
                    currentBrand = brand
                    filterByBrand(brand)
                }
            }
            binding.chipGroupBrands.addView(chip)
        }
    }
    
    private fun loadSmartphones() {
        val smartphones = SmartphoneData.getAllSmartphones()
        smartphoneAdapter.submitList(smartphones)
        updateItemCount(smartphones.size)
    }
    
    private fun filterByBrand(brand: String) {
        val filteredList = if (brand == "All") {
            SmartphoneData.getAllSmartphones()
        } else {
            SmartphoneData.getSmartphonesByBrand(brand)
        }
        smartphoneAdapter.submitList(filteredList)
        updateItemCount(filteredList.size)
    }
    
    private fun updateItemCount(count: Int) {
        binding.tvItemCount.text = "$count smartphone tersedia"
    }
    
    private fun navigateToDetail(smartphone: Smartphone) {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra(DetailActivity.EXTRA_SMARTPHONE, smartphone)
        }
        startActivity(intent)
    }
    
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> {
                startActivity(Intent(this, SearchActivity::class.java))
                true
            }
            R.id.action_compare -> {
                startActivity(Intent(this, CompareActivity::class.java))
                true
            }
            R.id.action_settings -> {
                startActivity(Intent(this, SettingsActivity::class.java))
                true
            }
            R.id.action_about -> {
                startActivity(Intent(this, AboutActivity::class.java))
                true
            }
            R.id.action_logout -> {
                logout()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    
    private fun logout() {
        val intent = Intent(this, LoginActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        startActivity(intent)
        finish()
    }
}
