package com.choala.network

import com.choala.network.model.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkService {
    @GET("character/")
    fun getCharactersAtPage(@Query("page") page: Int): Response<CharactersListDTO>

    @GET("location/")
    fun getLocationAtPage(@Query("page") page: Int): Response<LocationsListDTO>

    @GET("episode/")
    fun getEpisodeAtPage(@Query("page") page: Int): Response<EpisodesListDTO>

    @GET("character/{id}")
    fun getCharacter(@Path("id") characterId: Int): Response<CharacterDTO>

    @GET("location/{id}")
    fun getLocation(@Path("id") locationId: Int): Response<LocationDTO>

    @GET("episode/{id}")
    fun getEpisode(@Path("id") locationId: Int): Response<EpisodeDTO>
}