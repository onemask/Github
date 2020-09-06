package com.soo.github.network.remote

import com.soo.github.network.model.User
import com.soo.github.network.model.UserOverView
import com.soo.github.network.model.UserRepo

interface GithubRemoteDataSource {
    suspend fun getUserList(): List<User>

    suspend fun getUserOverView(user: String): UserOverView

    suspend fun getUserRepos(user: String): List<UserRepo>

    suspend fun getUserStarred(user: String): List<UserRepo>
}