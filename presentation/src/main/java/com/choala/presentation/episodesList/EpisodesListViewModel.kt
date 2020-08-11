package com.choala.presentation.episodesList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.choala.domain.model.EpisodeLite
import com.choala.domain.usecase.GetEpisodesWithPagination
import kotlinx.coroutines.flow.Flow

class EpisodesListViewModel(
    private val getEpisodesUseCase: GetEpisodesWithPagination
) : ViewModel() {
    fun getEpisodeList(): Flow<PagingData<EpisodeLite>> {
        return getEpisodesUseCase.getEpisodes().cachedIn(viewModelScope)
    }
}