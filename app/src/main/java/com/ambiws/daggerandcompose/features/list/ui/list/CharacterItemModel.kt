package com.ambiws.daggerandcompose.features.list.ui.list

import com.ambiws.daggerandcompose.base.list.ItemModel

interface CharacterBaseItemModel : ItemModel
data class CharacterItemModel(
    val name: String,
    val nickname: String,
    val house: String,
    val birthdate: String,
    val image: String,
) : CharacterBaseItemModel
