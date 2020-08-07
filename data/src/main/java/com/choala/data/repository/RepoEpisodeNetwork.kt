package com.choala.data.repository

import com.choala.data.model.EpisodeData
import com.choala.data.model.EpisodesListData
import com.choala.domain.state.Resource

interface RepoEpisodeNetwork {
    suspend fun getEpisode(id: Int): Resource<EpisodeData>
    suspend fun getEpisodes(page: Int): Resource<EpisodesListData>
    suspend fun getEpisodesList(idList: List<Int>): Resource<List<EpisodeData>>
}