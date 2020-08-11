package com.choala.domain.repo

import androidx.paging.PagingData
import com.choala.domain.model.*
import com.choala.domain.state.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getCharacters(): Flow<PagingData<CharacterLite>>
    fun getEpisodes(): Flow<PagingData<EpisodeLite>>
    suspend fun getCharacterDetail(id: Int): Resource<Character>
    fun getLocations(): Flow<PagingData<LocationLite>>
    suspend fun getLocationDetail(id: Int): Resource<Location>
    suspend fun getEpisodeDetail(id: Int): Resource<Episode>
}