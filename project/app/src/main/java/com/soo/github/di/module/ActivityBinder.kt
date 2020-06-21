package com.soo.github.di.module

import com.soo.github.di.scope.PerActivity
import com.soo.github.ui.user.MainActivity
import com.soo.github.ui.user.di.MainFragmentProvider
import com.soo.github.ui.userdetail.di.UserDetailFragmentProvider
import com.soo.github.ui.userdetail.di.UserOverViewFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinder {
    @PerActivity
    @ContributesAndroidInjector(
        modules = [MainFragmentProvider::class, UserDetailFragmentProvider::class, UserOverViewFragmentProvider::class]
    )
    abstract fun bindMainActivity(): MainActivity
}