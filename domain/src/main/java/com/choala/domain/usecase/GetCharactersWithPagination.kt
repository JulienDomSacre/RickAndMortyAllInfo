package com.choala.domain.usecase

import com.choala.domain.model.CharacterList
import com.choala.domain.repo.Repository
import com.choala.domain.state.Resource

class GetCharactersWithPagination(
    private val repository: Repository
) {
    suspend fun getCharacters(page: Int = 0): Resource<CharacterList> {
        return repository.getCharacters(page)
    }
}