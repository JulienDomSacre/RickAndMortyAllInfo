package com.choala.domain.di

import com.choala.domain.usecase.*
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetCharacterInfo(repository = get())
    }

    factory {
        GetCharatersWithPagination(repository = get())
    }

    factory {
        GetEpisodeInfo(repository = get())
    }

    factory {
        GetEpisodeWithPagination(repository = get())
    }

    factory {
        GetLocationInfo(repository = get())
    }

    factory {
        GetLocationsWithPagination(repository = get())
    }


}