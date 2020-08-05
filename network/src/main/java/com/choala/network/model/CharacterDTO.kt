package com.choala.network.model

import com.google.gson.annotations.SerializedName

data class CharacterDTO(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: LocationDTO,
    @SerializedName("location")
    val lastLocation: LocationDTO,
    val image: String,
    val episode: List<String>,
    val url: String
)