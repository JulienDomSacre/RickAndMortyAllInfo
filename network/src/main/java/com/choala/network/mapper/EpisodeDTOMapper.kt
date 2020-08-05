package com.choala.network.mapper

import com.choala.domain.model.CharacterLite
import com.choala.domain.model.EpisodeDetail
import com.choala.domain.model.EpisodeLite
import com.choala.network.model.EpisodeDTO

class EpisodeDTOMapper {
    fun mapToEpisodeDetail(dto: EpisodeDTO, charactersList: List<CharacterLite>): EpisodeDetail {
        return EpisodeDetail(
            dto.id,
            dto.name,
            dto.airDate,
            dto.episode,
            charactersList
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
}