package com.soo.github.ui.userdetail.di

import com.soo.github.di.scope.PerFragment
import com.soo.github.ui.userdetail.UserOverViewFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class UserOverViewFragmentProvider {
    @PerFragment
    @ContributesAndroidInjector(modules = [UserOverViewFragmentModule::class])
    abstract fun provideUserOverViewFragment(): UserOverViewFragment

}