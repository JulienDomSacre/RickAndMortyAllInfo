package com.choala.domain.repo

import androidx.paging.PagingData
import com.choala.domain.model.*
import com.choala.domain.state.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getCharacters(): Flow<PagingData<CharacterLite>>
    fun getEpisodes(): Flow<PagingData<EpisodeLite>>
    suspend fun getCharacter(id: Int): Resource<Character>
    suspend fun getLocations(page: Int): Resource<LocationList>
    suspend fun getLocationDetail(id: Int): Location
    suspend fun getEpisodeDetail(id: Int): Episode
}