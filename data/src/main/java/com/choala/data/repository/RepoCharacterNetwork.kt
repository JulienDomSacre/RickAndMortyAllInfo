package com.choala.data.repository

import com.choala.data.model.CharacterData
import com.choala.data.model.CharacterListData
import com.choala.domain.state.Resource

interface RepoCharacterNetwork {
    suspend fun getCharacter(id: Int): Resource<CharacterData>
    suspend fun getCharacters(page: Int): Resource<CharacterListData>
}