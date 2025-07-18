package com.ambiws.daggerandcompose.features.home.di

import com.ambiws.daggerandcompose.features.home.data.dataSource.HousesApi
import com.ambiws.daggerandcompose.features.home.data.dataSource.HousesDataSource
import com.ambiws.daggerandcompose.features.home.data.dataSource.HousesDataSourceImpl
import com.ambiws.daggerandcompose.features.home.domain.HousesInteractor
import com.ambiws.daggerandcompose.features.home.domain.HousesInteractorImpl
import dagger.Module
import dagger.Provides

@Module
class HouseModule {

    @Provides
    fun providesHousesDataSource(api: HousesApi): HousesDataSource {
        return HousesDataSourceImpl(api)
    }

    @Provides
    fun providesHousesInteractor(dataSource: HousesDataSource): HousesInteractor {
        return HousesInteractorImpl(dataSource)
    }
}
