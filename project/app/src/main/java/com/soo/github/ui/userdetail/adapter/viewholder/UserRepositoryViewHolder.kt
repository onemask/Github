package com.soo.github.ui.userdetail.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.soo.github.databinding.ItemUserRepositoryBinding
import com.soo.github.network.model.UserRepository
import com.soo.github.ui.vm.UserDetailViewModel

class UserRepositoryViewHolder(private val binding: ItemUserRepositoryBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: UserRepository, viewModel: UserDetailViewModel) {
        binding.vm = viewModel
        binding.userRepo = data
    }
}