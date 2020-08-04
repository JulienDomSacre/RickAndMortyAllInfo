package com.choala.network.model

data class PaginationDTO(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String?
)