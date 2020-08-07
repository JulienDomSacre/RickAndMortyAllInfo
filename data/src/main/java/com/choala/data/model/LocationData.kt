package com.choala.data.model

data class LocationData(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residentsId: List<Int?>,
    val url: String
)