package com.example.giphy.network

import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "YGHnKKBGSydS6nSt6WAoUcICWwmgCfvL"

interface GiphyApi {

    @GET("v1/gifs/search")
    suspend fun searchGif(
        @Query("q") query: String,
        @Query("offset") offset: Int,
        @Query("count") count: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): SearchResponse
}