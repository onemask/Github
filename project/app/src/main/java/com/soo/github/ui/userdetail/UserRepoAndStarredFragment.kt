package com.soo.github.ui.userdetail

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.soo.github.R
import com.soo.github.base.BaseFragment
import com.soo.github.constants.Constants
import com.soo.github.constants.Constants.POSITION
import com.soo.github.databinding.FragmentUserRepositoryBinding
import com.soo.github.ui.userdetail.adapter.UserRepositoryAdapter
import com.soo.github.ui.userdetail.adapter.UserStarredAdapter
import com.soo.github.ui.vm.UserRepoAndStarredViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class UserRepoAndStarredFragment :
    BaseFragment<FragmentUserRepositoryBinding>(layoutRes = R.layout.fragment_user_repository) {

    private val userName by lazy { arguments?.getString(Constants.USERNAME) }
    private val position by lazy { arguments?.getInt(POSITION) }

    private val repoAdapter by lazy { UserRepositoryAdapter(viewModel) }
    private val starredAdapter by lazy { UserStarredAdapter(viewModel) }

    override val viewModel by viewModels<UserRepoAndStarredViewModel>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        showContent()
        setupAdapter()
        setupBind()
    }

    private fun showContent() {
        when (position) {
            1 -> userName?.let { viewModel.getUserRepositories(it) }
            2 -> userName?.let { viewModel.getUserStarred(it) }
        }
    }

    private fun setupBind() {
        when (position) {
            1 -> viewModel.userRepositories.observe(viewLifecycleOwner, Observer {
                repoAdapter.setData(it)
            })
            2 -> viewModel.userStarred.observe(viewLifecycleOwner, Observer {
                starredAdapter.setData(it)
            })
        }
    }

    private fun setupAdapter() {
        when (position) {
            1 -> binding.rvUserRepo.also {
                it.adapter = repoAdapter
                it.addItemDecoration(DividerItemDecoration(context, 1))
            }
            2 -> binding.rvUserRepo.also {
                it.adapter = starredAdapter
                it.addItemDecoration(DividerItemDecoration(context, 1))
            }

        }

    }

    override fun setupViewModel() {
        binding.vm = viewModel
    }

    companion object {
        fun newInstance() = UserRepoAndStarredFragment()
    }

}
