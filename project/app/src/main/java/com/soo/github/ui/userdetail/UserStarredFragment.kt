package com.soo.github.ui.userdetail

import android.os.Bundle
import androidx.fragment.app.viewModels
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

    private var userName: String? = ""

    private val adapter by lazy { UserRepositoryAdapter(viewModel) }

    override val viewModel by viewModels<UserDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userName = it.getString(Constants.USERNAME)
        }
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            UserStarredFragment().apply {
                arguments = Bundle().apply {
                    putString(Constants.USERNAME, userName)
                }
            }
    }

}
