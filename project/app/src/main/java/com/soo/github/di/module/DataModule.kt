package com.soo.github.di.module

import com.soo.github.network.remote.GithubApiService
import com.soo.github.network.repository.GithubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
class DataModule {
    @Provides
    @ActivityRetainedScoped
    fun provideGithubRepository(apiService: GithubApiService) : GithubRepository = GithubRepository(apiService)
}