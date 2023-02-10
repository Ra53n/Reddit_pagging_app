package com.example.redditpaggingapp.data.api

import retrofit2.http.GET
import retrofit2.http.Query

interface RedditApi {

    @GET("/best.json")
    suspend fun getBestPosts(
        @Query("after") after: String? = null
    ): RedditResponse
}