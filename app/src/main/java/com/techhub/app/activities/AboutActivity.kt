package com.techhub.app.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
// IMPORT INI SANGAT PENTING:
import com.techhub.app.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi binding
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "About Developer"
            setDisplayHomeAsUpEnabled(true)
        }

        // Klik Email
        binding.layoutEmail.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:20230810003@uniku.ac.id")
                putExtra(Intent.EXTRA_SUBJECT, "Tanya TechHub App")
            }
            startActivity(Intent.createChooser(emailIntent, "Kirim email..."))
        }

        // Klik GitHub
        binding.layoutGithub.setOnClickListener {
            val url = "https://github.com/Muhamadnurul14"
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(browserIntent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}