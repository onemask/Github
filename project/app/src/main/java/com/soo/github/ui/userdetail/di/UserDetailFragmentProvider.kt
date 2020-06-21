package com.soo.github.ui.userdetail.di

import com.soo.github.di.scope.PerFragment
import com.soo.github.ui.userdetail.UserDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UserDetailFragmentProvider {
    @PerFragment
    @ContributesAndroidInjector
    abstract fun provideUserDetailFragment() : UserDetailFragment

}