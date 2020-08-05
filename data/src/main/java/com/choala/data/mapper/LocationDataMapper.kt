package com.choala.data.mapper

import com.choala.data.model.LocationData
import com.choala.data.model.LocationListData
import com.choala.domain.model.CharacterLite
import com.choala.domain.model.Location
import com.choala.domain.model.LocationList
import com.choala.domain.model.LocationLite

class LocationDataMapper {
    fun mapToLocationDetail(data: LocationData, characterList: List<CharacterLite>): Location {
        return Location(
            data.id,
            data.name,
            data.type,
            data.dimension,
            characterList,
            data.url
        )
    }

    fun mapToLocationLite(data: LocationData): LocationLite {
        return LocationLite(
            data.id,
            data.name,
            data.url
        )
    }

    fun mapToLocationsList(
        data: LocationListData,
        locationsList: List<LocationLite>
    ): LocationList {
        return LocationList(data.page, locationsList)
    }
}