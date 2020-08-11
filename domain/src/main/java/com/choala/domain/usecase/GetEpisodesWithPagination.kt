package com.choala.domain.usecase

import androidx.paging.PagingData
import com.choala.domain.model.EpisodeLite
import com.choala.domain.repo.Repository
import kotlinx.coroutines.flow.Flow

class GetEpisodesWithPagination(
    private val repository: Repository
) {
    fun getEpisodes(): Flow<PagingData<EpisodeLite>> {
        return repository.getEpisodes()
    }
}