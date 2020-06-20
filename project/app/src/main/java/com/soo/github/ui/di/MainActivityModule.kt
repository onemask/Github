package com.soo.github.ui.di

import androidx.lifecycle.ViewModel
import com.soo.github.di.scope.PerActivity
import com.soo.github.di.scope.key.ViewModelKey
import com.soo.github.ui.vm.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainActivityModule {
    @PerActivity
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(viewModel: MainViewModel) : ViewModel
}