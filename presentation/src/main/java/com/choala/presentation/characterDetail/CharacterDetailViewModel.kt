package com.choala.presentation.characterDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.choala.domain.usecase.GetCharacterInfo
import kotlinx.coroutines.Dispatchers

class CharacterDetailViewModel(private val characterUseCase: GetCharacterInfo) : ViewModel() {
    fun getCharacter(id: Int) = liveData(Dispatchers.IO) {
        val toto = characterUseCase.getCharacter(id)
        emit(toto)
    }
}