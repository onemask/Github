package com.soo.github.network.repository

import com.soo.github.network.model.User
import com.soo.github.network.remote.GithubRemoteDataSource
import io.reactivex.Single

class GithubRepositoryImpl(private val githubRemoteDataSource: GithubRemoteDataSource) :
    GithubRepository {
    override fun getUserList(): Single<List<User>> {
       //TODO("localRepository랑 분리 필요")
      return  githubRemoteDataSource.getUserList()
    }

}