package com.soo.github.network.remote

import com.soo.github.network.model.User
import io.reactivex.Single

interface GithubRemoteDataSource {
    fun getUserList() : Single<List<User>>
}