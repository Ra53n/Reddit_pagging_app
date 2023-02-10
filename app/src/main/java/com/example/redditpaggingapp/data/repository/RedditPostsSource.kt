package com.example.redditpaggingapp.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.redditpaggingapp.domain.model.RedditPostEntity

class RedditPostsSource(private val repository: RedditRepository) :
    PagingSource<String, RedditPostEntity>() {

    private var nextPageKey: String? = null

    override fun getRefreshKey(state: PagingState<String, RedditPostEntity>): String? {
        return null
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, RedditPostEntity> {
        val response = repository.getPosts(nextPageKey)
        nextPageKey = response.first
        return LoadResult.Page(
            data = response.second,
            prevKey = null,
            nextKey = nextPageKey
        )
    }
}