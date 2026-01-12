package com.techhub.app.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.techhub.app.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityLoginBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupClickListeners()
    }
    
    private fun setupClickListeners() {
        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            
            if (validateInput(username, password)) {
                // Kirim username ke MainActivity menggunakan Intent.putExtra
                navigateToMainActivity(username)
            }
        }
        
        binding.tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
    
    private fun validateInput(username: String, password: String): Boolean {
        return when {
            username.isEmpty() -> {
                binding.etUsername.error = "Username tidak boleh kosong"
                false
            }
            password.isEmpty() -> {
                binding.etPassword.error = "Password tidak boleh kosong"
                false
            }
            else -> true
        }
    }
    
    private fun navigateToMainActivity(username: String) {
        val intent = Intent(this, MainActivity::class.java).apply {
            // Kirim data username menggunakan Intent.putExtra
            putExtra(MainActivity.EXTRA_USERNAME, username)
        }
        startActivity(intent)
        finish() // Tutup LoginActivity
    }
}
