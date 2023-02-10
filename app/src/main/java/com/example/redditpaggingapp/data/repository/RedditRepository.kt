package com.example.redditpaggingapp.data.repository

import com.example.redditpaggingapp.domain.model.RedditPostEntity

interface RedditRepository {
    suspend fun getPosts(after: String? = null): Pair<String,List<RedditPostEntity>>
}