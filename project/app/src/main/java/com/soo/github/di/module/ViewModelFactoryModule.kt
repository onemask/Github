package com.soo.github.di.module

import androidx.lifecycle.ViewModelProvider
import com.soo.github.utils.CommonViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: CommonViewModelFactory): ViewModelProvider.Factory
}
