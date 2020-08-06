package com.choala.domain.usecase

import androidx.paging.PagingData
import com.choala.domain.model.CharacterLite
import com.choala.domain.repo.Repository
import kotlinx.coroutines.flow.Flow

class GetCharactersWithPagination(
    private val repository: Repository
) {
    fun getCharacters(): Flow<PagingData<CharacterLite>> {
        return repository.getCharacters()
    }
}