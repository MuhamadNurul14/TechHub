package com.techhub.app.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.techhub.app.adapters.SmartphoneAdapter
import com.techhub.app.databinding.ActivitySearchBinding
import com.techhub.app.models.Smartphone
import com.techhub.app.models.SmartphoneData

class SearchActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivitySearchBinding
    private lateinit var smartphoneAdapter: SmartphoneAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupToolbar()
        setupRecyclerView()
        setupSearchView()
    }
    
    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Cari Smartphone"
        }
    }
    
    private fun setupRecyclerView() {
        smartphoneAdapter = SmartphoneAdapter { smartphone ->
            navigateToDetail(smartphone)
        }
        
        binding.rvSearchResults.apply {
            layoutManager = LinearLayoutManager(this@SearchActivity)
            adapter = smartphoneAdapter
        }
        
        // Show all smartphones initially
        smartphoneAdapter.submitList(SmartphoneData.getAllSmartphones())
        updateResultCount(SmartphoneData.getAllSmartphones().size)
    }
    
    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { performSearch(it) }
                return true
            }
            
            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { performSearch(it) }
                return true
            }
        })
        
        // Auto focus search view
        binding.searchView.requestFocus()
    }
    
    private fun performSearch(query: String) {
        val results = if (query.isEmpty()) {
            SmartphoneData.getAllSmartphones()
        } else {
            SmartphoneData.searchSmartphones(query)
        }
        
        smartphoneAdapter.submitList(results)
        updateResultCount(results.size)
        
        // Show/hide empty state
        if (results.isEmpty()) {
            binding.tvEmptyState.visibility = android.view.View.VISIBLE
            binding.rvSearchResults.visibility = android.view.View.GONE
        } else {
            binding.tvEmptyState.visibility = android.view.View.GONE
            binding.rvSearchResults.visibility = android.view.View.VISIBLE
        }
    }
    
    private fun updateResultCount(count: Int) {
        binding.tvResultCount.text = "$count smartphone ditemukan"
    }
    
    private fun navigateToDetail(smartphone: Smartphone) {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra(DetailActivity.EXTRA_SMARTPHONE, smartphone)
        }
        startActivity(intent)
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
