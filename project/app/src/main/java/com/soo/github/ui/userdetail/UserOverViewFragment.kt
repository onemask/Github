package com.soo.github.ui.userdetail

import android.os.Bundle
import androidx.core.net.toUri
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.soo.github.R
import com.soo.github.base.BaseFragment
import com.soo.github.constants.Constants
import com.soo.github.databinding.FragmentUserOverViewBinding
import com.soo.github.ui.vm.UserOverViewViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserOverViewFragment :
        BaseFragment<FragmentUserOverViewBinding>(layoutRes = R.layout.fragment_user_over_view) {

    private var userName: String? = ""
    override val viewModel by viewModels<UserOverViewViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userName = it.getString(Constants.USERNAME)
        }
    }

    override fun setupViewModel() {
        binding.vm = viewModel
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        userName?.let {
            viewModel.getUserOverView(it)
        }
        setupBind()
    }

    private fun setupBind() {
        viewModel.userOverView.observe(viewLifecycleOwner, Observer {
            binding.ivUserImage.setImageURI(it.avatarUrl.toUri())
            binding.tvBio.text = it.bio
            binding.tvUserLogin.text = it.login
            binding.tvUserName.text = it.name

        })
    }

    companion object {
        fun newInstance(userName: String) = UserOverViewFragment().apply {
            arguments = Bundle().apply {
                putString(Constants.USERNAME, userName)
            }
        }
    }

}
