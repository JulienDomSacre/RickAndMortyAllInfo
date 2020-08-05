package com.choala.network.mapper

import com.choala.domain.model.CharacterLite
import com.choala.domain.model.LocationDetail
import com.choala.domain.model.LocationLite
import com.choala.network.model.LocationDTO

class LocationDTOMapper {
    fun mapToLocationDetail(dto: LocationDTO, characterList: List<CharacterLite>): LocationDetail {
        return LocationDetail(
            dto.id,
            dto.name,
            dto.type,
            dto.dimension,
            characterList,
            dto.url
        )
    }

    fun mapToLocationLite(dto: LocationDTO): LocationLite {
        return LocationLite(
            dto.id,
            dto.name,
            dto.url
        )
    }
}