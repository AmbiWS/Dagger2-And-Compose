package com.ambiws.daggerandcompose.features.list.data.dataSource

import com.ambiws.daggerandcompose.features.list.data.dataSource.response.CharacterResponse
import retrofit2.http.GET

const val API_CHARACTERS = "characters"

interface ListApi {

    @GET(API_CHARACTERS)
    suspend fun getCharacters(): List<CharacterResponse>
}
