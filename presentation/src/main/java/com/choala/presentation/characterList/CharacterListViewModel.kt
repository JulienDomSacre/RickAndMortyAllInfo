package com.choala.presentation.characterList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.choala.domain.model.CharacterLite
import com.choala.domain.usecase.GetCharactersWithPagination
import kotlinx.coroutines.flow.Flow

class CharacterListViewModel(
    private val getCharactersUseCase: GetCharactersWithPagination
) : ViewModel() {
    fun getCharacterList(): Flow<PagingData<CharacterLite>> {
        return getCharactersUseCase.getCharacters().cachedIn(viewModelScope)
    }

}