package com.example.giphy.section.list

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.giphy.model.GifItem
import com.example.giphy.section.list.GifsDataSource.Companion.PAGE_SIZE
import com.example.giphy.network.GiphyApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface IGifsPager {
    fun getGifs(): Flow<PagingData<GifItem>>
    fun setSearch(search: String)
}

class GifsPager @Inject constructor(
    private val api: GiphyApi
): IGifsPager {
    companion object {
        private var curSearch: String = ""
    }

    override fun getGifs() = Pager(PagingConfig(pageSize = PAGE_SIZE * 3)) {
            GifsDataSource(curSearch, api)
        }.flow

    override fun setSearch(search: String) {
        curSearch = search
    }
}