package com.choala.network.mapper

import com.choala.domain.model.CharacterDetail
import com.choala.domain.model.CharacterLite
import com.choala.domain.model.EpisodeLite
import com.choala.domain.model.LocationLite
import com.choala.network.model.CharacterDTO

class CharacterDTOMapper {
    fun mapToCharacterDetail(
        dto: CharacterDTO,
        origin: LocationLite,
        lastLocation: LocationLite,
        episodeList: List<EpisodeLite>
    ): CharacterDetail {
        return CharacterDetail(
            dto.id,
            dto.name,
            dto.status,
            dto.species,
            dto.type,
            dto.gender,
            origin,
            lastLocation,
            dto.image,
            episodeList
        )
    }

    fun mapToCharacterLite(dto: CharacterDTO): CharacterLite {
        return CharacterLite(
            dto.id,
            dto.name,
            dto.url
        )
    }
}