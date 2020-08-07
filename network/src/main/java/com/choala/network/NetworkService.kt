package com.choala.network

import com.choala.network.model.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkService {
    @GET("character/")
    suspend fun getCharactersAtPage(@Query("page") page: Int): Response<CharactersListDTO>

    @GET("location/")
    suspend fun getLocationAtPage(@Query("page") page: Int): Response<LocationsListDTO>

    @GET("episode/")
    suspend fun getEpisodeAtPage(@Query("page") page: Int): Response<EpisodesListDTO>

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") characterId: Int): Response<CharacterDTO>

    @GET("location/{id}")
    suspend fun getLocation(@Path("id") locationId: Int): Response<LocationDTO>

    @GET("episode/{id}")
    suspend fun getEpisode(@Path("id") episodeId: Int): Response<EpisodeDTO>

    @GET("character/{ids}")
    suspend fun getCharactersList(@Path("ids") ids: String): Response<CharactersListDTO>

    @GET("location/{ids}")
    suspend fun getLocationsList(@Path("ids") ids: List<Int>): Response<LocationsListDTO>

    @GET("episode/{ids}")
    suspend fun getEpisodesList(@Path("ids") ids: List<Int>): Response<List<EpisodeDTO>>
}