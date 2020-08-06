package com.choala.data.pagingSource

import androidx.paging.PagingSource
import com.choala.data.mapper.CharacterDataMapper
import com.choala.data.repository.RepoCharacterNetwork
import com.choala.domain.model.CharacterLite
import java.io.IOException

private const val RICK_AND_MORTY_STARTING_PAGE_INDEX = 1

class CharactersPagingSource(
    private val repoCharacter: RepoCharacterNetwork,
    private val characterMapper: CharacterDataMapper
) : PagingSource<Int, CharacterLite>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterLite> {
        val position = params.key ?: RICK_AND_MORTY_STARTING_PAGE_INDEX
        return try {
            val data = repoCharacter.getCharacters(position).data
            LoadResult.Page(
                data = characterMapper.mapToCharactersList(data!!).charactersList,
                prevKey = if (position == RICK_AND_MORTY_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (data.pageMax == position) null else position + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        }
//        catch (exception: HttpException) {
//            return LoadResult.Error(exception)
//        }
    }

}