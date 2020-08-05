package com.choala.domain.model

data class CharacterDetail(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: LocationLite,
    val lastLocation: LocationLite,
    val image: String,
    val episode: List<EpisodeLite>
)