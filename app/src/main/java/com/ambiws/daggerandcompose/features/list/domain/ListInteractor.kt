package com.ambiws.daggerandcompose.features.list.domain

import com.ambiws.daggerandcompose.features.list.data.dataSource.ListDataSource
import com.ambiws.daggerandcompose.features.list.domain.mapper.toDomain
import com.ambiws.daggerandcompose.features.list.domain.model.Character

interface ListInteractor {
    suspend fun getCharacters(): List<Character>
}

class ListInteractorImpl(
    private val dataSource: ListDataSource
): ListInteractor {

    override suspend fun getCharacters(): List<Character> {
        return dataSource.getCharacters().map {
            it.toDomain()
        }
    }
}
