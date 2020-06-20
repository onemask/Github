package com.soo.github.di.module

import com.soo.github.network.remote.GithubApiService
import com.soo.github.network.remote.GithubRemoteDataSource
import com.soo.github.network.repository.GithubRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    @Singleton
    fun provideGithubRepository(apiService: GithubApiService) : GithubRepository = GithubRepository(apiService)
}