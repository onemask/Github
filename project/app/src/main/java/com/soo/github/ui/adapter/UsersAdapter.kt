package com.soo.github.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.soo.github.R
import com.soo.github.databinding.ItemUserBinding
import com.soo.github.network.model.User
import com.soo.github.ui.adapter.viewholder.UserViewHolder

class UsersAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val dataSet = ArrayList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val item = DataBindingUtil.inflate<ItemUserBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_user,
            parent,
            false
        )
        return UserViewHolder(item)
    }

    override fun getItemCount(): Int  = dataSet.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as UserViewHolder).bind(data = dataSet[position])
    }

    fun setData(data : List<User>){
        dataSet.clear()
        dataSet.addAll(data)
        notifyDataSetChanged()
    }
}