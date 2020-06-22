package com.soo.github.network.repository

import com.soo.github.network.model.User
import com.soo.github.network.model.UserOverView
import com.soo.github.network.model.UserRepository
import com.soo.github.network.remote.GithubApiService
import com.soo.github.network.remote.GithubRemoteDataSource
import io.reactivex.Single

class GithubRepository(private val githubApiService: GithubApiService) :
    GithubRemoteDataSource {
    override fun getUserList(): Single<List<User>> {
        //TODO("localRepository랑 분리 필요")
        return githubApiService.getUserList()
    }

    override fun getUserOverView(user: String): Single<UserOverView> {
        return githubApiService.getUserOverView(user)
    }

    override fun getUserRepos(user: String): Single<List<UserRepository>> {
        return githubApiService.getUserRepos(user)
    }

}