package com.choala.network.di

import com.choala.network.NetworkCharacterService
import com.choala.network.NetworkEpisodeService
import com.choala.network.NetworkLocationService
import com.choala.network.NetworkService
import com.choala.network.mapper.CharacterDTOMapper
import com.choala.network.mapper.EpisodeDTOMapper
import com.choala.network.mapper.LocationDTOMapper
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val RICK_AND_MORTY_API = "rickAndMortyApi"
val networkModule = module {
    single(named(RICK_AND_MORTY_API)) {
        "https://rickandmortyapi.com/api/"
    }

    single {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        logging
    }

    single {
        val client = OkHttpClient.Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG)
            client.addInterceptor(get<HttpLoggingInterceptor>())
        client.build()
    }

    single {
        GsonBuilder()
            .setLenient()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            .setFieldNamingPolicy(
                FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES
            )
            .create()
    }

    single {
        Retrofit.Builder()
            .baseUrl(get<String>(named(RICK_AND_MORTY_API)))
            .client(get())
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()
    }

    single {
        get<Retrofit>().create(NetworkService::class.java)
    }

    factory { CharacterDTOMapper() }
    factory { EpisodeDTOMapper() }
    factory { LocationDTOMapper() }

    single {
        NetworkCharacterService(
            networkService = get(),
            characterMapper = get()
        )
    }

    single {
        NetworkEpisodeService(
            networkService = get(),
            episodeMapper = get()
        )
    }
    single {
        NetworkLocationService(
            networkService = get(),
            locationMapper = get()
        )
    }


}