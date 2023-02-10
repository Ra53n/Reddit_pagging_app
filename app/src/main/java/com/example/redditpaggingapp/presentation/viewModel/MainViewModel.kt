package com.example.redditpaggingapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.redditpaggingapp.data.repository.RedditPostsSource
import com.example.redditpaggingapp.data.repository.RedditRepository
import com.example.redditpaggingapp.domain.model.RedditPostEntity
import kotlinx.coroutines.flow.Flow

class MainViewModel(
    private val repository: RedditRepository
) : ViewModel() {

    val posts: Flow<PagingData<RedditPostEntity>> = Pager(PagingConfig(pageSize = 25)) {
        RedditPostsSource(repository)
    }.flow
        .cachedIn(viewModelScope)
}