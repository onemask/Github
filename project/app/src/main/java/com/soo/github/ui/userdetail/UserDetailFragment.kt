package com.soo.github.ui.userdetail

import android.os.Bundle
import androidx.navigation.fragment.navArgs
import com.soo.github.R
import com.soo.github.base.BaseFragment
import com.soo.github.base.BaseViewModel
import com.soo.github.databinding.FragmentUserDetailBinding
import com.soo.github.ui.userdetail.adapter.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailFragment : BaseFragment<FragmentUserDetailBinding>(
    R.layout.fragment_user_detail
) {
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private val name: UserDetailFragmentArgs by navArgs()

    override val viewModel: BaseViewModel = BaseViewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupAdapter()
    }

    private fun setupAdapter() {
        viewPagerAdapter = ViewPagerAdapter(requireParentFragment().parentFragmentManager, name.takeUserNames)
        binding.vp.adapter = viewPagerAdapter
        binding.layoutTap.setupWithViewPager(binding.vp)
    }

}
