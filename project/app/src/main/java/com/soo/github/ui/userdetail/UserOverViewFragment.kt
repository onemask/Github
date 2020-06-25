package com.soo.github.ui.userdetail

import android.os.Bundle
import android.widget.Toast
import androidx.core.net.toUri
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.soo.github.R
import com.soo.github.base.BaseFragment
import com.soo.github.constants.Constants
import com.soo.github.databinding.FragmentUserOverViewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserOverViewFragment :
    BaseFragment<FragmentUserOverViewBinding>(layoutRes = R.layout.fragment_user_over_view) {

    private val userName by lazy { arguments?.getString(Constants.USERNAME) ?: "" }
    override val viewModel by viewModels<UserOverViewModel>()

    override fun setupViewModel() {
        binding.vm = viewModel
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getUserOverView(userName)
        setupBind()
    }

    private fun setupBind() {
        viewModel.userOverView.observe(viewLifecycleOwner, Observer {
            binding.userOverView = it
            binding.ivUserImage.setImageURI(it.avatarUrl.toUri(), binding.ivUserImage.context)
        })

        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            Toast.makeText(this.context, it, Toast.LENGTH_SHORT).show()
        })
    }
}
