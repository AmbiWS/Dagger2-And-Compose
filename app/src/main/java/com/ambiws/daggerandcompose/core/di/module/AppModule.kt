package com.ambiws.daggerandcompose.core.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(app: Application) {

    private val appInstance: Application = app

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return appInstance
    }
}
