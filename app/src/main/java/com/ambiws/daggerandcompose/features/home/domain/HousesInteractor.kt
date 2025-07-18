package com.ambiws.daggerandcompose.features.home.domain

import com.ambiws.daggerandcompose.features.home.data.dataSource.HousesDataSource
import com.ambiws.daggerandcompose.features.home.domain.mapper.toDomain
import com.ambiws.daggerandcompose.features.home.domain.model.House

interface HousesInteractor {
    suspend fun getHouses(): List<House>
}

class HousesInteractorImpl(
    private val dataSource: HousesDataSource
): HousesInteractor {

    override suspend fun getHouses(): List<House> {
        return dataSource.getHouses().map {
            it.toDomain()
        }
    }
}
