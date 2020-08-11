package com.choala.presentation.di

import com.choala.presentation.characterDetail.CharacterDetailViewModel
import com.choala.presentation.charactersList.CharacterListViewModel
import com.choala.presentation.episodesList.EpisodesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { CharacterListViewModel(getCharactersUseCase = get()) }
    viewModel { CharacterDetailViewModel(characterUseCase = get()) }
    viewModel { EpisodesListViewModel(getEpisodesUseCase = get()) }
}