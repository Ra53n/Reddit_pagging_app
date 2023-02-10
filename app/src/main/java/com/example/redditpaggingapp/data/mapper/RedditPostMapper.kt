package com.example.redditpaggingapp.data.mapper

import com.example.redditpaggingapp.data.api.RedditResponse
import com.example.redditpaggingapp.domain.model.RedditPostEntity

class RedditPostMapper {

    fun map(response: RedditResponse): List<RedditPostEntity> {
        return response.data.posts.map { postResponse ->
            RedditPostEntity(
                title = postResponse.data.title,
                thumbnail = postResponse.data.thumbnail,
                subreddit = postResponse.data.subreddit,
                authorFullName = postResponse.data.authorFullName,
                commentsCount = postResponse.data.commentsCount
            )
        }
    }
}