package com.soo.github.ui.userdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.soo.github.R
import com.soo.github.constants.Constants
import com.soo.github.databinding.FragmentUserDetailBinding
import com.soo.github.ui.userdetail.adapter.ViewPagerAdapter
import dagger.android.support.DaggerFragment


class UserDetailFragment : DaggerFragment() {

    private lateinit var binding: FragmentUserDetailBinding
    private var userName: String? = ""
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userName = it.getString(Constants.USERNAME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_detail, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
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
