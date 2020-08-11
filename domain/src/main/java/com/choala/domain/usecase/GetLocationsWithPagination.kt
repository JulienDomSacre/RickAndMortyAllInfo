package com.choala.domain.usecase

import androidx.paging.PagingData
import com.choala.domain.model.LocationLite
import com.choala.domain.repo.Repository
import kotlinx.coroutines.flow.Flow

class GetLocationsWithPagination(
    private val repository: Repository
) {
    fun getLocations(): Flow<PagingData<LocationLite>> {
        return repository.getLocations()
    }
}