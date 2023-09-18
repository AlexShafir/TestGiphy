package com.example.giphy.network

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class SearchResponse(
    @JsonProperty("data") val data: List<GifObject>,
    @JsonProperty("pagination") val pagination: Pagination
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Pagination(
    @JsonProperty("total_count") val totalCount: Int
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class GifObject(
    @JsonProperty("images") val images: Images
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Images(
    @JsonProperty("original") val original: ImagesObject
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class ImagesObject(
    @JsonProperty("url") val url: String
)