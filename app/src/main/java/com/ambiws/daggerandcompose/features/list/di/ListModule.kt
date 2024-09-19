package com.ambiws.daggerandcompose.features.list.di

import com.ambiws.daggerandcompose.features.list.data.dataSource.ListApi
import com.ambiws.daggerandcompose.features.list.data.dataSource.ListDataSource
import com.ambiws.daggerandcompose.features.list.data.dataSource.ListDataSourceImpl
import com.ambiws.daggerandcompose.features.list.domain.ListInteractor
import com.ambiws.daggerandcompose.features.list.domain.ListInteractorImpl
import dagger.Module
import dagger.Provides

@Module
class ListModule {

    @Provides
    fun providesListDataSource(api: ListApi): ListDataSource {
        return ListDataSourceImpl(api)
    }

    @Provides
    fun providesListInteractor(dataSource: ListDataSource): ListInteractor {
        return ListInteractorImpl(dataSource)
    }
}
