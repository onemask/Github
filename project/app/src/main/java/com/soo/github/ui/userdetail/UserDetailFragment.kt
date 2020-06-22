package com.soo.github.ui.userdetail

import android.os.Bundle
import com.soo.github.R
import com.soo.github.base.BaseFragment
import com.soo.github.base.BaseViewModel
import com.soo.github.constants.Constants
import com.soo.github.databinding.FragmentUserDetailBinding
import com.soo.github.ui.userdetail.adapter.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailFragment :  BaseFragment<FragmentUserDetailBinding>(
    R.layout.fragment_user_detail
) {
    private var userName: String? = ""
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override val viewModel: BaseViewModel = BaseViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userName = it.getString(Constants.USERNAME)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupAdapter()
    }

    private fun setupAdapter() {
        viewPagerAdapter = ViewPagerAdapter(requireParentFragment().parentFragmentManager, userName ?: "")
        binding.vp.adapter = viewPagerAdapter
        binding.layoutTap.setupWithViewPager(binding.vp)
    }

}
