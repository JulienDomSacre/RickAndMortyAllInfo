package com.choala.domain.usecase

import com.choala.domain.model.Character
import com.choala.domain.repo.Repository
import com.choala.domain.state.Resource

class GetCharacterInfo(
    private val repository: Repository
) {
    suspend fun getCharacter(id: Int): Resource<Character> {
        return repository.getCharacterDetail(id)
    }
}