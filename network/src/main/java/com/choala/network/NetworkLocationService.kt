package com.choala.network

import com.choala.data.model.LocationData
import com.choala.data.model.LocationListData
import com.choala.data.repository.RepoLocationNetwork
import com.choala.domain.state.Resource
import com.choala.network.mapper.LocationDTOMapper

class NetworkLocationService(
    private val networkService: NetworkService,
    private val locationMapper: LocationDTOMapper
) : RepoLocationNetwork {
    override suspend fun getLocation(id: Int): Resource<LocationData> {
        val response = networkService.getLocation(id)
        when {
            response.isSuccessful -> return Resource.Success(
                locationMapper.mapToLocationData(
                    response.body()!!
                )
            )
        }
        return Resource.Error("error")
    }

    override suspend fun getLocationsList(page: Int): Resource<LocationListData> {
        TODO("Not yet implemented")
    }
}