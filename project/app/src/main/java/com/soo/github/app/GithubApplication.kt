package com.soo.github.app

import com.facebook.drawee.backends.pipeline.Fresco
import com.soo.github.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

class GithubApplication : DaggerApplication() {

    private val applicationInjector = DaggerAppComponent.builder().application(this).build()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Fresco.initialize(this)

    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = applicationInjector
}