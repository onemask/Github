package com.soo.github.network.remote

import com.soo.github.network.model.User
import io.reactivex.Single

class GithubRemoteDataSourceImpl(private val apiServiceService : GithubRemoteApiService) : GithubRemoteDataSource{
    override fun getUserList(): Single<List<User>> = apiServiceService.getUserList()

}