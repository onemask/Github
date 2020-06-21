package com.soo.github.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.soo.github.R
import com.soo.github.base.BaseActivity
import com.soo.github.databinding.ActivityMainBinding
import com.soo.github.ui.adapter.UsersAdapter
import com.soo.github.ui.vm.MainViewModel
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>(layoutRes = R.layout.activity_main) {

    @Inject
    lateinit var viewModelFactory : ViewModelProvider.Factory

    private val adapter = UsersAdapter()

    override val viewModel : MainViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupAdapter()
        setupBind()
    }

    override fun setupViewModel() {
        binding.vm = viewModel

    }

    private fun setupBind(){
        viewModel.userList.observe(this, Observer {
            adapter.setData(it)
        })
    }

    private fun setupAdapter(){
        binding.rvUserList.adapter = adapter
    }


}
