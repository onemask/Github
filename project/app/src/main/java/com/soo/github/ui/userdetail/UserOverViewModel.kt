package com.soo.github.ui.userdetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.soo.github.base.BaseViewModel
import com.soo.github.network.model.UserOverView
import com.soo.github.network.repository.GithubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserOverViewModel @ViewModelInject constructor(private val githubRepository: GithubRepository) :
    BaseViewModel() {

    private val _userOverView = MutableLiveData<UserOverView>()
    val userOverView: LiveData<UserOverView> get() = _userOverView

    /* fun getUserOverView(userName: String) {
         showLoading()
         githubRepository.getUserOverView(userName)
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe({
                 _userOverView.value = it
                 hideLoading()
             }, {
                 Timber.e("${it.printStackTrace()}")
                 errorMessage.value = it.message
             })
             .addTo(disposable)
     }*/

    fun getUserOverView(userName: String) {
        showLoading()
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            githubRepository.getUserOverView(userName).also { userOverView->
                withContext(Dispatchers.Main) {
                    _userOverView.value = userOverView
                    hideLoading()
                }
            }
        }
    }

}