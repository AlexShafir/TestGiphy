package com.example.giphy.section.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.giphy.model.GifItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ListVM @Inject constructor(private val repo: IGifsPager): ViewModel() {

    fun getGifs(): Flow<PagingData<GifItem>> {
        return repo.getGifs().cachedIn(viewModelScope)
    }

    fun setSearch(text: String) {
        repo.setSearch(text)
    }

}