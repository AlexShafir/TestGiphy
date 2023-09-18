package com.example.giphy.section.list

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.giphy.model.GifItem
import com.example.giphy.network.GiphyApi

class GifsDataSource(
    private val curSearch: String,
    private val api: GiphyApi
    ): PagingSource<Int, GifItem>() {

    companion object {
        const val PAGE_SIZE = 10 * 3
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GifItem> {
        return try {
            val nextPageNumber = params.key ?: 0
            val offset = nextPageNumber * PAGE_SIZE
            val response = api.searchGif(curSearch, nextPageNumber * PAGE_SIZE, PAGE_SIZE)

            LoadResult.Page(
                data = response.data.map { GifItem(it.images.original.url) },
                prevKey = if (nextPageNumber > 0) nextPageNumber - 1 else null,
                nextKey = if (offset < response.pagination.totalCount) nextPageNumber + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, GifItem>): Int? {
        return null
    }
}