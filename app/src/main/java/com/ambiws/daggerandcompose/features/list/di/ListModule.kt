package com.ambiws.daggerandcompose.features.list.di

import com.ambiws.daggerandcompose.features.list.data.dataSource.ListApi
import com.ambiws.daggerandcompose.features.list.data.dataSource.ListDataSource
import com.ambiws.daggerandcompose.features.list.data.dataSource.ListDataSourceImpl
import dagger.Module
import dagger.Provides

@Module
class ListModule {

    @Provides
    fun providesListDataSource(api: ListApi): ListDataSource {
        return ListDataSourceImpl(api)
    }
}
