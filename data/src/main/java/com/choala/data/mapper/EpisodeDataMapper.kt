package com.choala.data.mapper

import com.choala.data.model.EpisodeData
import com.choala.data.model.EpisodesListData
import com.choala.domain.model.CharacterLite
import com.choala.domain.model.Episode
import com.choala.domain.model.EpisodeList
import com.choala.domain.model.EpisodeLite

class EpisodeDataMapper {
    fun mapToEpisodeDetail(data: EpisodeData, charactersList: List<CharacterLite>): Episode {
        return Episode(
            data.id,
            data.name,
            data.airDate,
            data.episode,
            charactersList
        )
    }

    fun mapToEpisodeLite(data: EpisodeData): EpisodeLite {
        return EpisodeLite(
            data.id,
            data.name,
            data.episode,
            data.url
        )
    }

    fun mapToEpisodesList(data: EpisodesListData): EpisodeList {
        return EpisodeList(data.episodeList.map { mapToEpisodeLite(it) })
    }
}