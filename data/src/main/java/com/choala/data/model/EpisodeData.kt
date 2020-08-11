package com.choala.data.model

data class EpisodeData(
    val id: Int,
    val name: String,
    val airDate: String,
    val episode: String,
    val charactersId: List<Int>,
    val url: String
)