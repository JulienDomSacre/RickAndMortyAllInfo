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

    override suspend fun getEpisodesWithPagination(page: Int): Resource<EpisodesListData> {
        val response = networkService.getEpisodeAtPage(page)
        when {
            response.isSuccessful -> {
                return Resource.Success(
                    episodeMapper.mapToEpisodesListData(response.body()!!)
                )
            }
        }
        return Resource.Error("Error")
    }

    override suspend fun getEpisodesList(idList: List<Int>): Resource<List<EpisodeData>> {
        val response = networkService.getEpisodesList(idList)
        when {
            response.isSuccessful -> return Resource.Success(
                response.body()!!.map { episodeMapper.mapToEpisodeData(it) }
            )
        }
        return Resource.Error("error")
    }

}