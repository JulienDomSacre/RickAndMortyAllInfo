package com.choala.presentation.locationDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.choala.domain.usecase.GetLocationInfo
import kotlinx.coroutines.Dispatchers

class LocationDetailViewModel(private val locationUseCase: GetLocationInfo) : ViewModel() {
    fun getLocation(id: Int) = liveData(Dispatchers.IO) {
        emit(locationUseCase.getLocation(id))
    }
}