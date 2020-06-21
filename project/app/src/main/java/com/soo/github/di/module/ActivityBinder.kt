package com.soo.github.di.module

import com.soo.github.di.scope.PerActivity
import com.soo.github.ui.MainActivity
import com.soo.github.ui.di.MainFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinder {
    @PerActivity
    @ContributesAndroidInjector(modules = [MainFragmentProvider::class])
    abstract fun bindMainActivity(): MainActivity
}