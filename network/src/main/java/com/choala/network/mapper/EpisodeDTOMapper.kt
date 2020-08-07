package com.choala.network.mapper

import com.choala.data.model.EpisodeData
import com.choala.data.model.EpisodesListData
import com.choala.domain.model.EpisodeLite
import com.choala.network.model.EpisodeDTO
import com.choala.network.model.EpisodesListDTO
import com.choala.network.util.UrlHelper

class EpisodeDTOMapper {
    fun mapToEpisodeData(dto: EpisodeDTO): EpisodeData {
        return EpisodeData(
            dto.id,
            dto.name,
            dto.airDate,
            dto.episode,
            dto.characters.map { UrlHelper.getIdInUrl(it) },
            dto.url
        )
    }

    fun mapToEpisodeLite(dto: EpisodeDTO): EpisodeLite {
        return EpisodeLite(
            dto.id,
            dto.name,
            dto.episode,
            dto.url
        )
    }

    fun mapToEpisodesListData(dto: EpisodesListDTO): EpisodesListData {
        return EpisodesListData(
            dto.pagination.pages,
            dto.episodesList.map { mapToEpisodeData(it) }
        )
    }
}