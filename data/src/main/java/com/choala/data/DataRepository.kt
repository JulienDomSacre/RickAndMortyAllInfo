package com.choala.data

import com.choala.data.mapper.CharacterDataMapper
import com.choala.data.mapper.EpisodeDataMapper
import com.choala.data.mapper.LocationDataMapper
import com.choala.data.repository.RepoCharacterNetwork
import com.choala.data.repository.RepoEpisodeNetwork
import com.choala.data.repository.RepoLocationNetwork
import com.choala.domain.model.*
import com.choala.domain.repo.Repository
import com.choala.domain.state.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class DataRepository(
    private val repoCharacter: RepoCharacterNetwork,
    private val repoLocation: RepoLocationNetwork,
    private val repoEpisode: RepoEpisodeNetwork,
    private val characterMapper: CharacterDataMapper,
    private val locationMapper: LocationDataMapper,
    private val episodeMapper: EpisodeDataMapper
) : Repository {
    override suspend fun getCharacters(page: Int): Resource<CharacterList> {
        return Resource.Success(
            characterMapper.mapToCharactersList(
                repoCharacter.getCharacters(page).data!!
            )
        )
    }

    override suspend fun getCharacter(id: Int): Resource<Character> = withContext(Dispatchers.IO) {
        when (val state = repoCharacter.getCharacter(id)) {
            is Resource.Success -> {
                val lastLocation = async {
                    when (val stateLocation =
                        state.data!!.lastLocationId?.let { repoLocation.getLocation(it) }) {
                        is Resource.Success -> {
                            locationMapper.mapToLocationLite(stateLocation.data!!)
                        }
                        else -> null
                    }
                }

                val origin = async {
                    when (val stateOrigin =
                        state.data!!.originId?.let { repoLocation.getLocation(it) }) {
                        is Resource.Success -> {
                            locationMapper.mapToLocationLite(stateOrigin.data!!)
                        }
                        else -> null
                    }
                }

                val episodeList = async {
                    state.data!!.episode.map {
                        when (val stateEpisode = repoEpisode.getEpisode(it!!)) {
                            is Resource.Success -> episodeMapper.mapToEpisodeLite(stateEpisode.data!!)
                            else -> null
                        }
                    }
                }

                Resource.Success(
                    characterMapper.mapToCharacterDetail(
                        state.data!!,
                        origin.await(),
                        lastLocation.await(),
                        episodeList.await()
                    )
                )
            }
        }

        //Compilation error if I don't add the T type
        Resource.Error<Character>("Error")
    }

    override suspend fun getLocations(page: Int): Resource<LocationList> {
        TODO("Not yet implemented")
    }

    override suspend fun getLocationDetail(id: Int): Location {
        TODO("Not yet implemented")
    }

    override suspend fun getEpisodes(page: Int): EpisodeList {
        TODO("Not yet implemented")
    }

    override suspend fun getEpisodeDetail(id: Int): Episode {
        TODO("Not yet implemented")
    }
}