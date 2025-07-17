package com.ambiws.daggerandcompose.features.list.ui.list

import com.ambiws.daggerandcompose.base.list.ItemModel
import java.io.Serializable

interface CharacterBaseItemModel : ItemModel

// Added all endpoint properties in a single itemModel
// There is no '/details' endpoint on BE
data class CharacterItemModel(
    val name: String,
    val nickname: String,
    val house: String,
    val birthdate: String,
    val image: String,
    val children: String,
) : CharacterBaseItemModel, Serializable
