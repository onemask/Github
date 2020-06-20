package com.soo.github.di

import android.app.Application
import com.soo.github.app.GithubApplication
import com.soo.github.di.module.ActivityBinder
import com.soo.github.di.module.DataModule
import com.soo.github.di.module.NetworkModule
import com.soo.github.di.module.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        NetworkModule::class,
        DataModule::class,
        ActivityBinder::class,
        ViewModelFactoryModule::class
    ]
)

interface AppComponent : AndroidInjector<GithubApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: GithubApplication): Builder
        fun build(): AppComponent
    }

    fun inject(app: Application)
}