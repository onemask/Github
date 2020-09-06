package com.soo.github.network.repository

import com.soo.github.network.model.User
import com.soo.github.network.model.UserOverView
import com.soo.github.network.model.UserRepo
import com.soo.github.network.remote.GithubApiService
import com.soo.github.network.remote.GithubRemoteDataSource

class GithubRepository(private val githubApiService: GithubApiService) :
    GithubRemoteDataSource {

    override suspend fun getUserList(): List<User> {
        return githubApiService.getUserList()
    }

    override suspend fun getUserOverView(user: String): UserOverView {
        return githubApiService.getUserOverView(user)
    }

    override suspend fun getUserRepos(user: String): List<UserRepo> {
        return githubApiService.getUserRepos(user)
    }

    override suspend fun getUserStarred(user: String): List<UserRepo> {
        return githubApiService.getUserStarred(user)
    }

}