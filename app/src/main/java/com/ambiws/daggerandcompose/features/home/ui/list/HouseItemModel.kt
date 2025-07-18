package com.ambiws.daggerandcompose.features.home.ui.list

import com.ambiws.daggerandcompose.base.list.ItemModel

interface HouseBaseItemModel : ItemModel

data class HouseItemModel(
    val house: String,
    val emoji: String,
    val founder: String,
    val colors: String,
    val animal: String,
) : HouseBaseItemModel
