package com.soo.github.ui.userdetail

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.soo.github.R
import com.soo.github.base.BaseFragment
import com.soo.github.constants.Constants
import com.soo.github.databinding.FragmentUserStarredBinding
import com.soo.github.ui.userdetail.adapter.UserRepositoryAdapter
import com.soo.github.ui.vm.UserDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserStarredFragment :
    BaseFragment<FragmentUserStarredBinding>(layoutRes = R.layout.fragment_user_starred) {

    private val userName by lazy { arguments?.getString(Constants.USERNAME) }
    private val adapter by lazy { UserRepositoryAdapter(viewModel) }
    override val viewModel by viewModels<UserDetailViewModel>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        userName?.let {
            viewModel.getUserStarred(it)
        }
        setupAdapter()
        setupBind()
    }

    private fun setupBind() {
        viewModel.userStarred.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })
    }

    private fun setupAdapter() {
        binding.rvUserStarred.also {
            it.adapter = adapter
            it.addItemDecoration(DividerItemDecoration(context, 1))

        }
    }

    companion object {
        fun newInstance(userName: String) = UserStarredFragment().apply {
            arguments = Bundle().apply {
                putString(Constants.USERNAME, userName)
            }
        }
    }

}
