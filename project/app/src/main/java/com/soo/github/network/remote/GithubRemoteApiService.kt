package com.soo.github.network.remote

import com.soo.github.network.model.User
import io.reactivex.Single
import retrofit2.http.GET

interface GithubRemoteApiService {
    @GET("/users")
    fun getUserList() : Single<List<User>>
}