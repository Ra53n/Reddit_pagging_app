package com.example.redditpaggingapp.domain.model

import java.util.*

class RedditPostEntity(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val thumbnail: String,
    val subreddit: String,
    val authorFullName: String,
    val commentsCount: Int
)