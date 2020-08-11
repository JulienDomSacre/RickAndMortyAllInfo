package com.choala.presentation.episodeDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.choala.domain.usecase.GetEpisodeInfo
import kotlinx.coroutines.Dispatchers

class EpisodeDetailViewModel(private val episodeUseCase: GetEpisodeInfo) : ViewModel() {
    fun getEpisode(id: Int) = liveData(Dispatchers.IO) {
        emit(episodeUseCase.getEpisode(id))
    }
}