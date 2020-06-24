package com.soo.github.ui.userdetail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.soo.github.R
import com.soo.github.databinding.ItemUserRepositoryBinding
import com.soo.github.network.model.UserRepository
import com.soo.github.ui.userdetail.vm.UserRepoAndStarredViewModel

class UserRepositoryAdapter(private val andStarredViewModel: UserRepoAndStarredViewModel) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val dataSet = ArrayList<UserRepository>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val item = DataBindingUtil.inflate<ItemUserRepositoryBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_user_repository,
            parent,
            false
        )
        return UserRepositoryViewHolder(item)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as UserRepositoryViewHolder).bind(
            data = dataSet[position],
            andStarredViewModel = andStarredViewModel
        )
    }

    fun setData(data: List<UserRepository>) {
        dataSet.clear()
        dataSet.addAll(data)
        notifyDataSetChanged()
    }
}

class UserRepositoryViewHolder(private val binding: ItemUserRepositoryBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: UserRepository, andStarredViewModel: UserRepoAndStarredViewModel) {
        binding.vm = andStarredViewModel
        binding.userRepo = data
    }
}