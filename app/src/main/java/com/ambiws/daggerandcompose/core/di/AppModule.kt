package com.ambiws.daggerandcompose.core.di

import android.app.Application
import com.ambiws.daggerandcompose.features.home.data.NumbersRepository
import com.ambiws.daggerandcompose.utils.providers.PreferencesProvider
import com.ambiws.daggerandcompose.utils.providers.PreferencesProviderImpl
import com.ambiws.daggerandcompose.utils.providers.ResourceProvider
import com.ambiws.daggerandcompose.utils.providers.ResourceProviderImpl
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

    @Provides
    @Singleton
    fun provideRepository(): NumbersRepository {
        return NumbersRepository()
    }

    @Provides
    fun provideResourceProvider(context: Application): ResourceProvider {
        return ResourceProviderImpl(context)
    }

    @Provides
    fun providePreferencesProvider(context: Application): PreferencesProvider {
        return PreferencesProviderImpl(context)
    }
}
