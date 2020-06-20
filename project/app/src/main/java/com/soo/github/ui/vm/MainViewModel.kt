package com.soo.github.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.soo.github.base.BaseViewModel
import com.soo.github.network.model.User
import com.soo.github.network.repository.GithubRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(private val githubRepository: GithubRepository) :
    BaseViewModel() {

    private val _userList = MutableLiveData<List<User>>()
    val userList: LiveData<List<User>> get() = _userList

    init {
        getUserList()
    }

    private fun getUserList() {
        githubRepository.getUserList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { _loadingState.postValue(true) }
            .subscribe({
                _userList.postValue(it)
            }, {
                Timber.e("${it.printStackTrace()}")
            })
            .addTo(disposable)
    }
}