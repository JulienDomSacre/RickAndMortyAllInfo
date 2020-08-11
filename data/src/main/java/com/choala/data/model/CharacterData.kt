package com.choala.data.model

data class CharacterData(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val originId: Int?,
    val lastLocationId: Int?,
    val image: String,
    val episode: List<Int>,
    val url: String
)