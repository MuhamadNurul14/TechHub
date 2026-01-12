package com.techhub.app.activities

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.techhub.app.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivitySettingsBinding
    private lateinit var prefs: SharedPreferences
    
    companion object {
        const val PREFS_NAME = "TechHubPrefs"
        const val KEY_NOTIFICATIONS = "notifications"
        const val KEY_DARK_MODE = "dark_mode"
        const val KEY_LANGUAGE = "language"
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        
        setupToolbar()
        loadSettings()
        setupListeners()
    }
    
    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Pengaturan"
        }
    }
    
    private fun loadSettings() {
        binding.switchNotifications.isChecked = prefs.getBoolean(KEY_NOTIFICATIONS, true)
        binding.switchDarkMode.isChecked = prefs.getBoolean(KEY_DARK_MODE, false)
        
        val language = prefs.getString(KEY_LANGUAGE, "id") ?: "id"
        binding.spinnerLanguage.setSelection(
            when (language) {
                "en" -> 1
                "zh" -> 2
                else -> 0
            }
        )
    }
    
    private fun setupListeners() {
        // Notifications
        binding.switchNotifications.setOnCheckedChangeListener { _, isChecked ->
            prefs.edit().putBoolean(KEY_NOTIFICATIONS, isChecked).apply()
            val message = if (isChecked) "Notifikasi diaktifkan" else "Notifikasi dinonaktifkan"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
        
        // Dark Mode
        binding.switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            prefs.edit().putBoolean(KEY_DARK_MODE, isChecked).apply()
            
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
        
        // Clear Cache
        binding.btnClearCache.setOnClickListener {
            clearCache()
        }
        
        // Privacy Settings
        binding.btnPrivacy.setOnClickListener {
            Toast.makeText(this, "Fitur Privasi & Keamanan", Toast.LENGTH_SHORT).show()
        }
    }
    
    private fun clearCache() {
        try {
            cacheDir.deleteRecursively()
            Toast.makeText(this, "Cache berhasil dihapus", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, "Gagal menghapus cache", Toast.LENGTH_SHORT).show()
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
