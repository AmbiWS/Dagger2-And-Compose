package com.ambiws.daggerandcompose.features.home.data.dataSource

import com.ambiws.daggerandcompose.features.home.data.dataSource.response.HouseResponse

interface HousesDataSource {
    suspend fun getHouses(): List<HouseResponse>
}

class HousesDataSourceImpl(
    private val api: HousesApi
) : HousesDataSource {

    override suspend fun getHouses(): List<HouseResponse> {
        return api.getHouses()
    }
}
