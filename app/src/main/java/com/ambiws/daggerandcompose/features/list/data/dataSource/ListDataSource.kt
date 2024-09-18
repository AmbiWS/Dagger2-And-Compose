package com.ambiws.daggerandcompose.features.list.data.dataSource

import com.ambiws.daggerandcompose.features.list.data.dataSource.response.CharactersResponse

interface ListDataSource {
    suspend fun getCharacters(): List<CharactersResponse>
}

class ListDataSourceImpl(
    private val api: ListApi
) : ListDataSource {

    override suspend fun getCharacters(): List<CharactersResponse> {
        return api.getCharacters()
    }
}
