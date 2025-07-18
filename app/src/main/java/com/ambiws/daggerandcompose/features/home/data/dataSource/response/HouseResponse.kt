package com.ambiws.daggerandcompose.features.home.data.dataSource.response

import com.google.gson.annotations.SerializedName

data class HouseResponse(
    @SerializedName("house")
    val house: String?,
    @SerializedName("emoji")
    val emoji: String?,
    @SerializedName("founder")
    val founder: String?,
    @SerializedName("colors")
    val colors: List<String>?,
    @SerializedName("animal")
    val animal: String?,
)
