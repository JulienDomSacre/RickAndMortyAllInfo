package com.choala.network.mapper

import com.choala.data.model.CharacterData
import com.choala.data.model.CharacterListData
import com.choala.network.model.CharacterDTO
import com.choala.network.model.CharactersListDTO
import com.choala.network.util.UrlHelper

class CharacterDTOMapper {
    fun mapToCharacterData(
        dto: CharacterDTO
    ): CharacterData {
        return CharacterData(
            dto.id,
            dto.name,
            dto.status,
            dto.species,
            dto.type,
            dto.gender,
            UrlHelper.getIdInUrl(dto.lastLocation.url),
            UrlHelper.getIdInUrl(dto.origin.url),
            dto.image,
            dto.episode.map { UrlHelper.getIdInUrl(it) },
            dto.url
        )
    }


    fun mapToCharactersListData(
        dto: CharactersListDTO
    ): CharacterListData {
        return CharacterListData(
            dto.pagination.pages,
            dto.charactersList.map { mapToCharacterData(it) })
    }
}