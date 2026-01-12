package com.techhub.app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.techhub.app.R
import com.techhub.app.databinding.ItemSmartphoneBinding
import com.techhub.app.models.Smartphone

class SmartphoneAdapter(
    private val onItemClick: (Smartphone) -> Unit
) : ListAdapter<Smartphone, SmartphoneAdapter.SmartphoneViewHolder>(SmartphoneDiffCallback()) {

    inner class SmartphoneViewHolder(
        private val binding: ItemSmartphoneBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(smartphone: Smartphone) {
            binding.apply {
                tvSmartphoneName.text = smartphone.name
                tvBrand.text = smartphone.brand
                tvPrice.text = smartphone.price
                tvRam.text = smartphone.ram
                tvStorage.text = smartphone.storage
                tvProcessor.text = smartphone.processor

                // Load image menggunakan Glide
                Glide.with(itemView.context)
                    .load(smartphone.imageUrl)
                    .placeholder(R.drawable.placeholder_phone)
                    .error(R.drawable.placeholder_phone)
                    .centerCrop()
                    .into(ivSmartphone)

                // Click listener untuk CardView
                root.setOnClickListener {
                    onItemClick(smartphone)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmartphoneViewHolder {
        val binding = ItemSmartphoneBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SmartphoneViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SmartphoneViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class SmartphoneDiffCallback : DiffUtil.ItemCallback<Smartphone>() {
    override fun areItemsTheSame(oldItem: Smartphone, newItem: Smartphone): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Smartphone, newItem: Smartphone): Boolean {
        return oldItem == newItem
    }
}
