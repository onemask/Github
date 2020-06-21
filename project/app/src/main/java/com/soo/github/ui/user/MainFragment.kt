package com.soo.github.ui.user

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.soo.github.R
import com.soo.github.base.BaseFragment
import com.soo.github.constants.Constants
import com.soo.github.databinding.FragmentMainBinding
import com.soo.github.ui.user.adapter.UsersAdapter
import com.soo.github.ui.user.vm.MainViewModel
import javax.inject.Inject

class MainFragment : BaseFragment<FragmentMainBinding>(layoutRes = R.layout.fragment_main) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override val viewModel: MainViewModel by viewModels { viewModelFactory }

    private val adapter by lazy { UsersAdapter(viewModel) }

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

        viewModel.user.observe(viewLifecycleOwner, Observer {
            val args = Bundle()
            args.putString(Constants.USERNAME, it.login)
            findNavController().navigate(R.id.action_main_to_detail, args)
        })
    }

}
