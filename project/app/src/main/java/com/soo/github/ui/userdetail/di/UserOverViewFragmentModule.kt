package com.soo.github.ui.userdetail.di

import androidx.lifecycle.ViewModel
import com.soo.github.di.scope.PerFragment
import com.soo.github.di.scope.key.ViewModelKey
import com.soo.github.ui.vm.UserOverViewViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class UserOverViewFragmentModule {
    @PerFragment
    @Binds
    @IntoMap
    @ViewModelKey(UserOverViewViewModel::class)
    abstract fun bindUserOverViewViewModel(viewModel: UserOverViewViewModel): ViewModel

}