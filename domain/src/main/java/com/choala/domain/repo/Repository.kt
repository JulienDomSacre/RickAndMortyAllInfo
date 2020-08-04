package com.choala.domain.repo

import com.choala.domain.model.*

interface Repository {
    fun getCharacters(page: Int): CharacterList
    fun getCharacterDetail(id: Int): CharacterDetail
    fun getLocations(page: Int): LocationList
    fun getLocationDetail(id: Int): LocationDetail
    fun getEpisodes(page: Int): EpisodeList
    fun getEpisodeDetail(id: Int): EpisodeDetail
}