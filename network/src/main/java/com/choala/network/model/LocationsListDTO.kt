package com.choala.network.model

import com.google.gson.annotations.SerializedName


data class LocationsListDTO(
    @SerializedName("info")
    val pagination: PaginationDTO,
    @SerializedName("results")
    val locationsList: List<LocationDTO>
)