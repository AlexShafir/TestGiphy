package com.example.giphy.di

import com.example.giphy.section.list.GifsPager
import com.example.giphy.section.list.IGifsPager
import com.example.giphy.network.GiphyApi
import com.example.giphy.network.RetrofitClient
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class VmModule {
    @Binds
    abstract fun bindGifsRepo(impl: GifsPager): IGifsPager

    companion object {
        @Provides
        fun provideGiphyApi(): GiphyApi {
            val retrofit = RetrofitClient.getClient()
            return retrofit.create(GiphyApi::class.java)
        }
    }
}