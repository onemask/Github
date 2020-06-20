package com.soo.github.di.module

import com.soo.github.di.scope.PerActivity
import com.soo.github.ui.MainActivity
import com.soo.github.ui.di.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinder {
    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
}