package com.soo.github.network.repository

import com.soo.github.network.model.User
import io.reactivex.Single

interface GithubRepository{
    fun getUserList() : Single<List<User>>
}