package com.choala.network

import com.choala.data.model.CharacterData
import com.choala.data.model.CharacterListData
import com.choala.data.repository.RepoCharacterNetwork
import com.choala.domain.state.Resource
import com.choala.network.mapper.CharacterDTOMapper

class NetworkCharacterService(
    private val networkService: NetworkService,
    private val characterMapper: CharacterDTOMapper
) : RepoCharacterNetwork {
    override suspend fun getCharacter(id: Int): Resource<CharacterData> {
        val response = networkService.getCharacter(id)
        when {
            response.isSuccessful -> {
                return Resource.Success(characterMapper.mapToCharacterData(response.body()!!))
            }
        }
        return Resource.Error("error")
    }

    override suspend fun getCharacters(page: Int): Resource<CharacterListData> {
        val response = networkService.getCharactersAtPage(page)
        when {
            response.isSuccessful -> {
                return Resource.Success(
                    characterMapper.mapToCharactersListData(response.body()!!)
                )
            }
        }
        return Resource.Error("Error")
    }
}
