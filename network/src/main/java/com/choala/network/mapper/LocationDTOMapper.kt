package com.choala.network.mapper

import com.choala.data.model.LocationData
import com.choala.data.model.LocationListData
import com.choala.network.model.LocationDTO
import com.choala.network.model.LocationsListDTO
import com.choala.network.util.UrlHelper

class LocationDTOMapper {
    fun mapToLocationData(dto: LocationDTO): LocationData {
        return LocationData(
            dto.id,
            dto.name,
            dto.type,
            dto.dimension,
            dto.residents.map { UrlHelper.getIdInUrl(it) },
            dto.url
        )
    }

    fun mapToLocationsListData(
        dto: LocationsListDTO
    ): LocationListData {
        return LocationListData(
            dto.pagination.pages,
            dto.locationsList.map { mapToLocationData(it) })
    }
}