package com.choala.network.model

import com.google.gson.annotations.SerializedName


data class CharactersListDTO(
    @SerializedName("info")
    val pagination: PaginationDTO,
    @SerializedName("results")
    val charactersList: List<CharacterDTO>
)