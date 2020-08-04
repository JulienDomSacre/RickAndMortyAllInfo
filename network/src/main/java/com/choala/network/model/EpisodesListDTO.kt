package com.choala.network.model

import com.google.gson.annotations.SerializedName


data class EpisodesListDTO(
    @SerializedName("info")
    val pagination: PaginationDTO,
    @SerializedName("results")
    val episodesList: List<EpisodeDTO>
)

