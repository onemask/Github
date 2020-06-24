package com.soo.github.ui.user

import android.os.Bundle
import android.util.ArrayMap
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.soo.github.R
import com.soo.github.base.BaseAdapter
import com.soo.github.base.BaseFragment
import com.soo.github.base.BaseViewModel
import com.soo.github.constants.Constants
import com.soo.github.databinding.FragmentMainBinding
import com.soo.github.network.model.User
import com.soo.github.ui.user.adapter.UsersAdapter
import com.soo.github.ui.user.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(layoutRes = R.layout.fragment_main) {

    override val viewModel by viewModels<MainViewModel>()

    private val adapter by lazy { UsersAdapter(viewModel) }

    override fun setupViewModel() {
        binding.vm = viewModel
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupAdapter()
        setupObserve()
        showContents()
    }

    private fun showContents() {
        viewModel.getUserList()
    }

    private fun setupAdapter() {
        val madapter = BaseAdapter<User>(
            layoutBindingId = Pair(R.layout.item_user, BR.user),
            viewModels = ArrayMap<Int, BaseViewModel>().apply {
                put(BR.vm, viewModel)
            }
        )
        binding.rvUserList.adapter = madapter

       // binding.rvUserList.adapter = adapter
    }

    private fun setupObserve() {
        viewModel.userList.observe(viewLifecycleOwner, Observer {
          //  adapter.setData(it)
        })

        //TODO("BackButton 을 구현 하기 위해서는 singleEvent 정의 ")
        viewModel.user.observe(viewLifecycleOwner, Observer {
            val args = Bundle()
            args.putString(Constants.USERNAME, it.login)
            it.login?.let { name ->
                val action = MainFragmentDirections.actionMainToDetail(takeUserNames = it.login)
                findNavController().navigate(action)
            }
        })
    }

}
