package com.soo.github.ui.user

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.soo.github.base.BaseViewModel
import com.soo.github.network.model.User
import com.soo.github.network.repository.GithubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel @ViewModelInject constructor(private val githubRepository: GithubRepository) :
    BaseViewModel() {

    private val _userList = MutableLiveData<List<User>>()
    val userList: LiveData<List<User>> get() = _userList

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    fun getUserList() {
        showLoading()
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            withContext(Dispatchers.Main) {
                githubRepository.getUserList().apply {
                    _userList.value = this
                }
                hideLoading()
            }
        }

    }

    fun showUserDetail(data: User) {
        _user.value = data
    }
}