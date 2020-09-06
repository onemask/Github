package com.soo.github.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineExceptionHandler

open class BaseViewModel : ViewModel() {

    protected val disposable = CompositeDisposable()
    open val errorMessage = MutableLiveData<String>()

    protected val coroutineExceptionHandler =
        CoroutineExceptionHandler { coroutineContext, throwable ->
            throwable.printStackTrace()
        }

    protected val _loadingState = MutableLiveData<Boolean>()
    val loadingState: LiveData<Boolean>
        get() = _loadingState

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }

    protected fun hideLoading() {
        _loadingState.value = false
    }

    protected fun showLoading() {
        _loadingState.value = true
    }
}
