package com.soo.github.ui.userdetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.soo.github.base.BaseViewModel
import com.soo.github.network.model.UserRepo
import com.soo.github.network.repository.GithubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserRepoAndStarredViewModel @ViewModelInject constructor(private val githubRepository: GithubRepository) :
    BaseViewModel() {

    private val _userRepositories = MutableLiveData<List<UserRepo>>()
    val userRepositories: LiveData<List<UserRepo>> get() = _userRepositories

    private val _userStarred = MutableLiveData<List<UserRepo>>()
    val userStarred: LiveData<List<UserRepo>> get() = _userStarred

    fun getUserRepositories(userName: String) {
        showLoading()
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            withContext(Dispatchers.Main) {
                githubRepository.getUserRepos(userName).apply {
                    _userRepositories.value = this
                }
                hideLoading()
            }
        }
    }


    fun getUserStarred(userName: String) {
        showLoading()
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            withContext(Dispatchers.Main) {
                githubRepository.getUserStarred(userName).apply {
                    _userStarred.value = this
                }
                hideLoading()
            }
        }
    }
}