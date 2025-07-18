package com.ambiws.daggerandcompose.features.home.data.dataSource

import com.ambiws.daggerandcompose.features.home.data.dataSource.response.HouseResponse
import retrofit2.http.GET

const val API_HOUSES = "houses"

interface HousesApi {

    @GET(API_HOUSES)
    suspend fun getHouses(): List<HouseResponse>
}
