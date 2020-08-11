package com.choala.presentation.locationsList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.choala.domain.model.LocationLite
import com.choala.domain.usecase.GetLocationsWithPagination
import kotlinx.coroutines.flow.Flow

class LocationListViewModel(
    private val getLocationsUseCase: GetLocationsWithPagination
) : ViewModel() {
    fun getLocationsList(): Flow<PagingData<LocationLite>> {
        return getLocationsUseCase.getLocations().cachedIn(viewModelScope)
    }
}