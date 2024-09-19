package com.ambiws.daggerandcompose.features.list.data.dataSource.response

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("fullName")
    val name: String?,
    @SerializedName("nickname")
    val nickname: String?,
    @SerializedName("hogwartsHouse")
    val house: String?,
    @SerializedName("birthdate")
    val birthdate: String?,
    @SerializedName("image")
    val image: String?,
)
