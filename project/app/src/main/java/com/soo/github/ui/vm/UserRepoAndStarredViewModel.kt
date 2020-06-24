package com.soo.github.ui.vm

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.soo.github.base.BaseViewModel
import com.soo.github.network.model.UserRepository
import com.soo.github.network.repository.GithubRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import timber.log.Timber

class UserRepoAndStarredViewModel @ViewModelInject constructor(private val githubRepository: GithubRepository) :
    BaseViewModel() {

    private val _userRepositories = MutableLiveData<List<UserRepository>>()
    val userRepositories: LiveData<List<UserRepository>> get() = _userRepositories

    private val _userStarred = MutableLiveData<List<UserRepository>>()
    val userStarred: LiveData<List<UserRepository>> get() = _userStarred

    fun getUserRepositories(userName: String) {
        showLoading()
        githubRepository.getUserRepos(userName)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { _loadingState.postValue(true) }
            .subscribe({
                _userRepositories.postValue(it)
                hideLoading()
            }, {
                Timber.e("${it.printStackTrace()}")
            })
            .addTo(disposable)
    }

    fun getUserStarred(userName: String) {
        showLoading()
        githubRepository.getUserStarred(userName)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { _loadingState.postValue(true) }
            .subscribe({
                _userStarred.postValue(it)
                hideLoading()
            }, {
                Timber.e("${it.printStackTrace()}")
            })
            .addTo(disposable)

    }

}