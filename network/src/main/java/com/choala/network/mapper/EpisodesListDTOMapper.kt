package com.choala.network.mapper

import com.choala.domain.model.EpisodeList
import com.choala.domain.model.EpisodeLite
import com.choala.network.model.PaginationDTO

class EpisodesListDTOMapper {
    fun mapToEpisodesList(pagination: PaginationDTO, episodesList: List<EpisodeLite>): EpisodeList {
        return EpisodeList(pagination.pages, episodesList)
    }
}