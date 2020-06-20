package com.soo.github.di

import android.app.Application
import com.soo.github.app.GithubApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class
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