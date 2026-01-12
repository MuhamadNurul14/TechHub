package com.techhub.app.activities

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.techhub.app.R
import com.techhub.app.databinding.ActivityOnboardingBinding

data class OnboardingItem(
    val iconResId: Int,
    val title: String,
    val description: String
)

class OnboardingActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityOnboardingBinding
    private lateinit var onboardingAdapter: OnboardingAdapter
    
    private val onboardingItems = listOf(
        OnboardingItem(
            R.drawable.ic_search,
            "Temukan Smartphone Impianmu",
            "Jelajahi katalog lengkap smartphone terbaru dari berbagai brand ternama"
        ),
        OnboardingItem(
            R.drawable.ic_compare,
            "Bandingkan Spesifikasi",
            "Bandingkan detail spesifikasi antar smartphone untuk pilihan terbaik"
        ),
        OnboardingItem(
            R.drawable.ic_info,
            "Informasi Lengkap & Akurat",
            "Dapatkan info detail harga, spesifikasi, dan review dari setiap produk"
        )
    )
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupViewPager()
        setupButtons()
    }
    
    private fun setupViewPager() {
        onboardingAdapter = OnboardingAdapter(onboardingItems)
        binding.viewPager.adapter = onboardingAdapter
        
        // Setup indicator
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateIndicators(position)
                updateButton(position)
            }
        })
        
        updateIndicators(0)
    }
    
    private fun setupButtons() {
        binding.btnSkip.setOnClickListener {
            navigateToLogin()
        }
        
        binding.btnNext.setOnClickListener {
            if (binding.viewPager.currentItem < onboardingItems.size - 1) {
                binding.viewPager.currentItem += 1
            } else {
                navigateToLogin()
            }
        }
    }
    
    private fun updateIndicators(position: Int) {
        binding.indicator1.alpha = if (position == 0) 1f else 0.3f
        binding.indicator2.alpha = if (position == 1) 1f else 0.3f
        binding.indicator3.alpha = if (position == 2) 1f else 0.3f
    }
    
    private fun updateButton(position: Int) {
        if (position == onboardingItems.size - 1) {
            binding.btnNext.text = "Mulai"
        } else {
            binding.btnNext.text = "Selanjutnya"
        }
    }
    
    private fun navigateToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}

class OnboardingAdapter(private val items: List<OnboardingItem>) : 
    RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>() {
    
    inner class OnboardingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.ivIcon)
        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val description: TextView = itemView.findViewById(R.id.tvDescription)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_onboarding, parent, false)
        return OnboardingViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        val item = items[position]
        holder.icon.setImageResource(item.iconResId)
        holder.title.text = item.title
        holder.description.text = item.description
    }
    
    override fun getItemCount(): Int = items.size
}
