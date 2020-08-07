package com.choala.presentation.di

import com.choala.presentation.characterList.CharacterListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { CharacterListViewModel(getCharactersUseCase = get()) }
}