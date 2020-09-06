package com.soo.github.network.remote

import com.soo.github.network.model.User
import com.soo.github.network.model.UserOverView
import com.soo.github.network.model.UserRepo
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApiService {
    @GET("/users")
    suspend fun getUserList(): List<User>

    @GET("/users/{user}")
    suspend fun getUserOverView(@Path("user") user: String): UserOverView

    @GET("/users/{user}/repos")
    suspend fun getUserRepos(@Path("user") user: String): List<UserRepo>

    @GET("/users/{user}/starred")
    suspend fun getUserStarred(@Path("user") user: String): List<UserRepo>
}
