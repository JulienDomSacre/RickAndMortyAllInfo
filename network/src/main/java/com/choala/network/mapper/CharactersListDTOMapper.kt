package com.choala.network.mapper

import com.choala.domain.model.CharacterList
import com.choala.domain.model.CharacterLite
import com.choala.network.model.PaginationDTO

class CharactersListDTOMapper {
    fun mapToCharactersList(
        pagination: PaginationDTO,
        charactersList: List<CharacterLite>
    ): CharacterList {
        return CharacterList(pagination.pages, charactersList)
    }
}