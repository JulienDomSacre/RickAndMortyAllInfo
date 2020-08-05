package com.choala.data.mapper

import com.choala.data.model.CharacterData
import com.choala.data.model.CharacterListData
import com.choala.domain.model.*

class CharacterDataMapper {
    fun mapToCharacterDetail(
        data: CharacterData,
        origin: LocationLite?,
        lastLocation: LocationLite?,
        episodeList: List<EpisodeLite?>
    ): Character {
        return Character(
            data.id,
            data.name,
            data.status,
            data.species,
            data.type,
            data.gender,
            lastLocation,
            origin,
            data.image,
            episodeList
        )
    }

    fun mapToCharacterLite(data: CharacterData): CharacterLite {
        return CharacterLite(
            data.id,
            data.name,
            data.url
        )
    }

    fun mapToCharactersList(
        data: CharacterListData
    ): CharacterList {
        return CharacterList(
            data.page,
            data.charactersList.map { mapToCharacterLite(it) })
    }
}