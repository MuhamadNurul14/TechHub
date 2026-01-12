package com.techhub.app.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.techhub.app.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivitySplashBinding
    private val splashDelay: Long = 3000 // 3 detik
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        // Timer 3 detik sebelum pindah ke OnboardingActivity
        Handler(Looper.getMainLooper()).postDelayed({
            navigateToOnboarding()
        }, splashDelay)
    }
    
    private fun navigateToOnboarding() {
        val intent = Intent(this, OnboardingActivity::class.java)
        startActivity(intent)
        finish() // Tutup SplashActivity agar tidak bisa kembali
    }
}
