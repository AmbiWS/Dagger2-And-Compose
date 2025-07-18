package com.ambiws.daggerandcompose.features.home.domain.mapper

import com.ambiws.daggerandcompose.features.home.data.dataSource.response.HouseResponse
import com.ambiws.daggerandcompose.features.home.domain.model.House
import com.ambiws.daggerandcompose.features.home.ui.list.HouseItemModel
import com.ambiws.daggerandcompose.utils.extensions.throwIfNull

fun HouseResponse.toDomain() = House(
    house = house.throwIfNull(),
    emoji = emoji.throwIfNull(),
    founder = founder.throwIfNull(),
    colors = colors.throwIfNull(),
    animal = animal.throwIfNull(),
)

fun House.toItemModel() = HouseItemModel(
    house = house,
    emoji = emoji,
    founder = founder,
    colors = colors.joinToString(separator = ", ") { color -> color.replaceFirstChar { it.titlecase() } },
    animal = animal,
)
