package com.soo.github.network.remote

import com.soo.github.network.model.User
import com.soo.github.network.model.UserOverView
import com.soo.github.network.model.UserRepository
import io.reactivex.Single

interface GithubRemoteDataSource {
    fun getUserList(): Single<List<User>>

    fun getUserOverView(user: String): Single<UserOverView>

    fun getUserRepos(user : String) : Single<List<UserRepository>>

}