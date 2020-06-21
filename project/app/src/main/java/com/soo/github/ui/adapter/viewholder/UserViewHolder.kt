package com.soo.github.ui.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.soo.github.databinding.ItemUserBinding
import com.soo.github.network.model.User

class UserViewHolder(private val binding : ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data : User){
        binding.user = data
    }
}