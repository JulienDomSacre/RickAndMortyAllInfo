package com.choala.network

import com.choala.data.model.EpisodeData
import com.choala.data.model.EpisodesListData
import com.choala.data.repository.RepoEpisodeNetwork
import com.choala.domain.state.Resource
import com.choala.network.mapper.EpisodeDTOMapper

class NetworkEpisodeService(
    private val networkService: NetworkService,
    private val episodeMapper: EpisodeDTOMapper
) : RepoEpisodeNetwork {
    override suspend fun getEpisode(id: Int): Resource<EpisodeData> {
        val response = networkService.getEpisode(id)
        when {
            response.isSuccessful -> return Resource.Success(
                episodeMapper.mapToEpisodeData(
                    response.body()!!
                )
            )
        }
        return Resource.Error("error")
    }

    override suspend fun getEpisodes(page: Int): Resource<EpisodesListData> {
        TODO("Not yet implemented")
    }

}