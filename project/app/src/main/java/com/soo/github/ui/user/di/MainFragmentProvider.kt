package com.soo.github.ui.user.di

import com.soo.github.di.scope.PerFragment
import com.soo.github.ui.user.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class MainFragmentProvider {
    @PerFragment
    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun provideMainFragment(): MainFragment
}