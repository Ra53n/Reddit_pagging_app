package com.example.redditpaggingapp.data.api

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class RedditResponse(
    val data: RedditResponseData
) : Serializable

class RedditResponseData(
    val after: String?,
    val before: String?,
    @SerializedName("children")
    val posts: List<RedditPostResponse>
) : Serializable

class RedditPostResponse(
    val data: RedditPostResponseData
)

class RedditPostResponseData(
    val title: String,
    val thumbnail: String,
    val subreddit: String,
    @SerializedName("author_fullname")
    val authorFullName: String,
    @SerializedName("num_comments")
    val commentsCount: Int
) : Serializable