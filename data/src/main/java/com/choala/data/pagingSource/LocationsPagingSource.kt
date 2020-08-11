package com.choala.data.pagingSource

import androidx.paging.PagingSource
import com.choala.data.mapper.LocationDataMapper
import com.choala.data.repository.RepoLocationNetwork
import com.choala.domain.model.LocationLite
import java.io.IOException

private const val RICK_AND_MORTY_STARTING_PAGE_INDEX = 1

class LocationsPagingSource(
    private val repo: RepoLocationNetwork,
    private val mapper: LocationDataMapper
) : PagingSource<Int, LocationLite>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LocationLite> {
        val position = params.key ?: RICK_AND_MORTY_STARTING_PAGE_INDEX
        return try {
            val data = repo.getLocationsWithPagination(position).data
            LoadResult.Page(
                data = mapper.mapToLocationsList(data!!).locationList,
                prevKey = if (position == RICK_AND_MORTY_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (data.pageMax == position) null else position + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        }
    }

}