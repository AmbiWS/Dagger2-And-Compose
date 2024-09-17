package com.ambiws.daggerandcompose.features.list.data.dataSource

interface ListDataSource {
    fun getCharacters(): List<CharactersResponse>
}

class ListDataSourceImpl(
    private val api: ListApi
) : ListDataSource {

    override fun getCharacters(): List<CharactersResponse> {
        api.getCharacters()
    }
}
