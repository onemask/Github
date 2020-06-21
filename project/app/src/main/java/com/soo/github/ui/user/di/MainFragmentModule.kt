package com.soo.github.ui.user.di

import androidx.lifecycle.ViewModel
import com.soo.github.di.scope.PerFragment
import com.soo.github.di.scope.key.ViewModelKey
import com.soo.github.ui.user.vm.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class MainFragmentModule {
    @PerFragment
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}