package com.soo.github.ui

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.soo.github.R
import com.soo.github.base.BaseFragment
import com.soo.github.databinding.FragmentMainBinding
import com.soo.github.ui.adapter.UsersAdapter
import com.soo.github.ui.vm.MainViewModel
import javax.inject.Inject

class MainFragment : BaseFragment<FragmentMainBinding>(layoutRes = R.layout.fragment_main) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val adapter = UsersAdapter()

    override val viewModel: MainViewModel by viewModels { viewModelFactory }

    override fun setupViewModel() {
        binding.vm = viewModel
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupAdpater()
        setupBind()
    }

    private fun setupAdpater() {
        binding.rvUserList.adapter = adapter
    }

    private fun setupBind() {
        viewModel.userList.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })
    }

}
