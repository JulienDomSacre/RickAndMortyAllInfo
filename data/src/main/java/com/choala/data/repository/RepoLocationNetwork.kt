package com.choala.data.repository

import com.choala.data.model.LocationData
import com.choala.data.model.LocationListData
import com.choala.domain.state.Resource

interface RepoLocationNetwork {
    fun getLocation(id: Int): Resource<LocationData>
    fun getLocationsList(page: Int): Resource<LocationListData>
}