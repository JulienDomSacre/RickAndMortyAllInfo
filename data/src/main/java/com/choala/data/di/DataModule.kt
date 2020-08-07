package com.choala.data.di

import com.choala.data.DataRepository
import com.choala.data.mapper.CharacterDataMapper
import com.choala.data.mapper.EpisodeDataMapper
import com.choala.data.mapper.LocationDataMapper
import com.choala.domain.repo.Repository
import org.koin.dsl.module

val dataModule = module {
    factory {
        CharacterDataMapper()
    }

    factory {
        EpisodeDataMapper()
    }

    factory {
        LocationDataMapper()
    }

    single<Repository> {
        DataRepository(
            repoCharacter = get(),
            repoLocation = get(),
            repoEpisode = get(),
            characterMapper = get(),
            locationMapper = get(),
            episodeMapper = get()
        )
    }
}