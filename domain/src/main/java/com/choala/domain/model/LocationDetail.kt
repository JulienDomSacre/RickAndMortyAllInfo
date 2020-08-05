package com.choala.domain.model

data class LocationDetail(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<CharacterLite>,
    val url: String
)