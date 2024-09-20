package com.ambiws.daggerandcompose.features.list.domain.mapper

import com.ambiws.daggerandcompose.features.list.data.dataSource.response.CharacterResponse
import com.ambiws.daggerandcompose.features.list.domain.model.Character
import com.ambiws.daggerandcompose.features.list.ui.model.CharacterItemModel
import com.ambiws.daggerandcompose.utils.extensions.throwIfNull

fun CharacterResponse.toDomain() = Character(
    name = name,
    nickname = nickname ?: "",
    house = house ?: "Undefined",
    birthdate = birthdate,
    image = image,
)

fun Character.toItemModel() = CharacterItemModel(
    name = name.throwIfNull(),
    nickname = nickname,
    house = house,
    birthdate = birthdate.throwIfNull(),
    image = image.throwIfNull(),
)
