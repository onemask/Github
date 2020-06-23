package com.soo.github.ui.userdetail

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.soo.github.R
import com.soo.github.base.BaseFragment
import com.soo.github.constants.Constants
import com.soo.github.databinding.FragmentUserRepositoryBinding
import com.soo.github.ui.userdetail.adapter.UserRepositoryAdapter
import com.soo.github.ui.vm.UserDetailViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class UserRepositoryFragment :
    BaseFragment<FragmentUserRepositoryBinding>(layoutRes = R.layout.fragment_user_repository) {

    private val userName by lazy { arguments?.getString(Constants.USERNAME) }
    private val adapter by lazy { UserRepositoryAdapter(viewModel) }
    override val viewModel by viewModels<UserDetailViewModel>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        userName?.let {
            viewModel.getUserRepositories(it)
        }
        setupAdapter()
        setupBind()
    }

    private fun setupBind() {
        viewModel.userRepositories.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })
    }

    private fun setupAdapter() {
        binding.rvUserRepo.also {
            it.adapter = adapter
            it.addItemDecoration(DividerItemDecoration(context, 1))
        }
    }

    override fun setupViewModel() {
        binding.vm = viewModel
    }

    companion object {
        fun newInstance(userName: String) = UserRepositoryFragment().apply {
            arguments = Bundle().apply {
                putString(Constants.USERNAME, userName)
            }
        }
    }

}
