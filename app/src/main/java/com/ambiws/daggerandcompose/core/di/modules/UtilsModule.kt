package com.ambiws.daggerandcompose.core.di.modules

import android.content.Context
import com.ambiws.daggerandcompose.utils.providers.PreferencesProvider
import com.ambiws.daggerandcompose.utils.providers.PreferencesProviderImpl
import com.ambiws.daggerandcompose.utils.providers.ResourceProvider
import com.ambiws.daggerandcompose.utils.providers.ResourceProviderImpl
import dagger.Module
import dagger.Provides

@Module
class UtilsModule {

    @Provides
    fun provideResourceProvider(context: Context): ResourceProvider {
        return ResourceProviderImpl(context)
    }

    @Provides
    fun providePreferencesProvider(context: Context): PreferencesProvider {
        return PreferencesProviderImpl(context)
    }
}
