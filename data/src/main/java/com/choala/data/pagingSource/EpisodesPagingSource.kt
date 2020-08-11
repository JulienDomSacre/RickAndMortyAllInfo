package com.choala.data.pagingSource

import androidx.paging.PagingSource
import com.choala.data.mapper.EpisodeDataMapper
import com.choala.data.repository.RepoEpisodeNetwork
import com.choala.domain.model.EpisodeLite
import java.io.IOException

private const val RICK_AND_MORTY_STARTING_PAGE_INDEX = 1

class EpisodesPagingSource(
    private val repo: RepoEpisodeNetwork,
    private val mapper: EpisodeDataMapper
) : PagingSource<Int, EpisodeLite>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, EpisodeLite> {
        val position = params.key ?: RICK_AND_MORTY_STARTING_PAGE_INDEX
        return try {
            val data = repo.getEpisodesWithPagination(position).data
            LoadResult.Page(
                data = mapper.mapToEpisodesList(data!!).episodeList,
                prevKey = if (position == RICK_AND_MORTY_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (data.pageMax == position) null else position + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        }
    }

}