package com.ambiws.daggerandcompose.features.list.data.dataSource

import com.ambiws.daggerandcompose.features.list.data.dataSource.response.CharacterResponse

interface ListDataSource {
    suspend fun getCharacters(): List<CharacterResponse>
}

class ListDataSourceImpl(
    private val api: ListApi
) : ListDataSource {

    override suspend fun getCharacters(): List<CharacterResponse> {
        return api.getCharacters()
    }
}
