package com.choala.domain.usecase

import com.choala.domain.model.Location
import com.choala.domain.repo.Repository
import com.choala.domain.state.Resource

class GetLocationInfo(
    private val repository: Repository
) {
    suspend fun getLocation(id: Int): Resource<Location> {
        return repository.getLocationDetail(id)
    }
}