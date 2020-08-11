package com.choala.presentation.di

import com.choala.presentation.characterDetail.CharacterDetailViewModel
import com.choala.presentation.charactersList.CharacterListViewModel
import com.choala.presentation.episodeDetail.EpisodeDetailViewModel
import com.choala.presentation.episodesList.EpisodesListViewModel
import com.choala.presentation.locationDetail.LocationDetailViewModel
import com.choala.presentation.locationsList.LocationListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { CharacterListViewModel(getCharactersUseCase = get()) }
    viewModel { CharacterDetailViewModel(characterUseCase = get()) }
    viewModel { EpisodesListViewModel(getEpisodesUseCase = get()) }
    viewModel { EpisodeDetailViewModel(episodeUseCase = get()) }
    viewModel { LocationListViewModel(getLocationsUseCase = get()) }
    viewModel { LocationDetailViewModel(locationUseCase = get()) }
}