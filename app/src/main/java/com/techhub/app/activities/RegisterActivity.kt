package com.techhub.app.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.techhub.app.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityRegisterBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupClickListeners()
    }
    
    private fun setupClickListeners() {
        binding.btnRegister.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val confirmPassword = binding.etConfirmPassword.text.toString().trim()
            
            if (validateInput(username, email, password, confirmPassword)) {
                // Kirim username ke MainActivity menggunakan Intent.putExtra
                navigateToMainActivity(username)
            }
        }
        
        binding.tvLogin.setOnClickListener {
            finish() // Kembali ke LoginActivity
        }
    }
    
    private fun validateInput(
        username: String,
        email: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        return when {
            username.isEmpty() -> {
                binding.etUsername.error = "Username tidak boleh kosong"
                false
            }
            email.isEmpty() -> {
                binding.etEmail.error = "Email tidak boleh kosong"
                false
            }
            !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                binding.etEmail.error = "Format email tidak valid"
                false
            }
            password.isEmpty() -> {
                binding.etPassword.error = "Password tidak boleh kosong"
                false
            }
            password.length < 6 -> {
                binding.etPassword.error = "Password minimal 6 karakter"
                false
            }
            confirmPassword.isEmpty() -> {
                binding.etConfirmPassword.error = "Konfirmasi password tidak boleh kosong"
                false
            }
            password != confirmPassword -> {
                binding.etConfirmPassword.error = "Password tidak cocok"
                Toast.makeText(this, "Password tidak cocok!", Toast.LENGTH_SHORT).show()
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
        finish() // Tutup RegisterActivity
    }
}
