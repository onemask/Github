package com.soo.github.network.remote

import com.soo.github.network.model.User
import com.soo.github.network.model.UserOverView
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApiService {
    @GET("/users")
    fun getUserList(): Single<List<User>>

    @GET("/users/{user}")
    fun getUserOverView(@Path("user") user: String): Single<UserOverView>
}