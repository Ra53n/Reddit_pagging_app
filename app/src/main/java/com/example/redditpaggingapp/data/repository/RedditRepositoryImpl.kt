package com.example.redditpaggingapp.data.repository

import com.example.redditpaggingapp.data.api.RedditApi
import com.example.redditpaggingapp.data.mapper.RedditPostMapper
import com.example.redditpaggingapp.domain.model.RedditPostEntity

class RedditRepositoryImpl(
    private val api: RedditApi,
    private val mapper: RedditPostMapper
) : RedditRepository {
    override suspend fun getPosts(after: String?): Pair<String, List<RedditPostEntity>> {
        val result = api.getBestPosts(after)
        return Pair(result.data.after ?: "", mapper.map(result))
    }
}