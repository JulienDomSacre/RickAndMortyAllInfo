package com.choala.domain.usecase

import com.choala.domain.model.Episode
import com.choala.domain.repo.Repository
import com.choala.domain.state.Resource

class GetEpisodeInfo(
    private val repository: Repository
) {
    suspend fun getEpisode(id: Int): Resource<Episode> {
        return repository.getEpisodeDetail(id)
    }
}