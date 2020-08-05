package com.choala.domain.repo

import com.choala.domain.model.*
import com.choala.domain.state.Resource

interface Repository {
    suspend fun getCharacters(page: Int): Resource<CharacterList>
    suspend fun getCharacter(id: Int): Resource<Character>
    suspend fun getLocations(page: Int): Resource<LocationList>
    suspend fun getLocationDetail(id: Int): Location
    suspend fun getEpisodes(page: Int): EpisodeList
    suspend fun getEpisodeDetail(id: Int): Episode
}