package com.soo.github.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {

    protected val disposable = CompositeDisposable()
    protected val _loadingState = MutableLiveData<Boolean>()

    val loadingState: LiveData<Boolean>
        get() = _loadingState


    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

    open fun hideLoading() {
        _loadingState.value = false
    }

    open fun showLoading() {
        _loadingState.value = true
    }
}
