package com.choala.network.mapper

import com.choala.domain.model.LocationList
import com.choala.domain.model.LocationLite
import com.choala.network.model.PaginationDTO

class LocationsListDTOMapper {
    fun mapToLocationsList(
        pagination: PaginationDTO,
        locationsList: List<LocationLite>
    ): LocationList {
        return LocationList(pagination.pages, locationsList)
    }
}