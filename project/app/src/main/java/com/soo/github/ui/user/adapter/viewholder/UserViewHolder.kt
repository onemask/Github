package com.soo.github.ui.user.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.soo.github.databinding.ItemUserBinding
import com.soo.github.network.model.User
import com.soo.github.ui.user.vm.MainViewModel

class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: User,viewModel: MainViewModel) {
        binding.user = data
        binding.vm = viewModel
    }
}