package com.choala.domain.model

data class EpisodeList(
    val page: Int,
    val episodeList: List<EpisodeLite>
)