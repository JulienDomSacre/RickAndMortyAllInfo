package com.choala.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.choala.data.mapper.CharacterDataMapper
import com.choala.data.mapper.EpisodeDataMapper
import com.choala.data.mapper.LocationDataMapper
import com.choala.data.pagingSource.CharactersPagingSource
import com.choala.data.pagingSource.EpisodesPagingSource
import com.choala.data.pagingSource.LocationsPagingSource
import com.choala.data.repository.RepoCharacterNetwork
import com.choala.data.repository.RepoEpisodeNetwork
import com.choala.data.repository.RepoLocationNetwork
import com.choala.domain.model.*
import com.choala.domain.repo.Repository
import com.choala.domain.state.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class DataRepository(
    private val repoCharacter: RepoCharacterNetwork,
    private val repoLocation: RepoLocationNetwork,
    private val repoEpisode: RepoEpisodeNetwork,
    private val characterMapper: CharacterDataMapper,
    private val locationMapper: LocationDataMapper,
    private val episodeMapper: EpisodeDataMapper
) : Repository {
    override fun getCharacters(): Flow<PagingData<CharacterLite>> {
        return Pager(
            PagingConfig(pageSize = 20),
            pagingSourceFactory = { CharactersPagingSource(repoCharacter, characterMapper) }
        ).flow
    }

    override suspend fun getCharacterDetail(id: Int): Resource<Character> =
        withContext(Dispatchers.IO) {
            when (val state = repoCharacter.getCharacter(id)) {
                is Resource.Success -> {
                    val lastLocation = async {
                        state.data!!.lastLocationId?.let { getLocationLite(it) }
                    }

                    val origin = async {
                        state.data!!.originId?.let { getLocationLite(it) }
                    }

                    val episodeList = async {
                        getEpisodeLiteList(state.data!!.episode)
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
                else -> //Compilation error if I don't add the T type
                    Resource.Error<Character>("Error")
            }

        }

    override fun getLocations(): Flow<PagingData<LocationLite>> {
        return Pager(
            PagingConfig(pageSize = 20),
            pagingSourceFactory = { LocationsPagingSource(repoLocation, locationMapper) }
        ).flow
    }

    override suspend fun getLocationDetail(id: Int): Resource<Location> =
        withContext(Dispatchers.IO) {
            when (val state = repoLocation.getLocation(id)) {
                is Resource.Success -> {
                    val characterList = async {
                        getCharacterLiteList(state.data!!.residentsId)
                    }

                    Resource.Success(
                        locationMapper.mapToLocationDetail(
                            state.data!!,
                            characterList.await()
                        )
                    )
                }
                else ->
                    //Compilation error if I don't add the T type
                    Resource.Error<Location>("Error")
            }
        }

    override fun getEpisodes(): Flow<PagingData<EpisodeLite>> {
        return Pager(
            PagingConfig(pageSize = 20),
            pagingSourceFactory = { EpisodesPagingSource(repoEpisode, episodeMapper) }
        ).flow
    }

    override suspend fun getEpisodeDetail(id: Int): Resource<Episode> =
        withContext(Dispatchers.IO) {
            when (val state = repoEpisode.getEpisode(id)) {
                is Resource.Success -> {
                    val characterList = async {
                        getCharacterLiteList(state.data!!.charactersId)
                    }

                    Resource.Success(
                        episodeMapper.mapToEpisodeDetail(
                            state.data!!,
                            characterList.await()
                        )
                    )
                }
                else -> //Compilation error if I don't add the T type
                    Resource.Error<Episode>("Error")
            }
        }

    private suspend fun getEpisodeLiteList(episodeList: List<Int>): List<EpisodeLite> {
        return when (val state = repoEpisode.getEpisodesList(episodeList)) {
            is Resource.Success -> {
                state.data!!.map {
                    episodeMapper.mapToEpisodeLite(it)
                }
            }
            else -> emptyList()
        }
    }

    private suspend fun getLocationLite(locationId: Int): LocationLite? {
        return when (val state = repoLocation.getLocation(locationId)) {
            is Resource.Success -> {
                locationMapper.mapToLocationLite(state.data!!)
            }
            else -> null
        }
    }

    private suspend fun getCharacterLiteList(charactersList: List<Int>): List<CharacterLite> {
        return when (val state = repoCharacter.getCharactersList(charactersList)) {
            is Resource.Success -> {
                state.data!!.map {
                    characterMapper.mapToCharacterLite(it)
                }
            }
            else -> emptyList()
        }
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 20
    }
}