package com.soo.github.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.soo.github.base.BaseViewModel
import com.soo.github.network.model.UserOverView
import com.soo.github.network.repository.GithubRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class UserOverViewViewModel @Inject constructor(private val githubRepository: GithubRepository) :
    BaseViewModel() {

    private val _userOverView = MutableLiveData<UserOverView>()
    val userOverView: LiveData<UserOverView> get() = _userOverView

    fun getUserOverView(userName: String) {
        githubRepository.getUserOverView(userName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { _loadingState.postValue(true) }
            .subscribe({
                _userOverView.postValue(it)
            }, {
                Timber.e("${it.printStackTrace()}")

            })
            .addTo(disposable)
    }

}