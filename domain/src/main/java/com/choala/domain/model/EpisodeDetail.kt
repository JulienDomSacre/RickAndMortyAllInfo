package com.choala.domain.model

data class EpisodeDetail(
    val id: Int,
    val name: String,
    val airDate: String,
    val episode: String,
    val characters: List<CharacterDetail>
)