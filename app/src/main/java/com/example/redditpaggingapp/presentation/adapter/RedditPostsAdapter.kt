package com.example.redditpaggingapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.example.redditpaggingapp.R
import com.example.redditpaggingapp.databinding.PostItemBinding
import com.example.redditpaggingapp.domain.model.RedditPostEntity

class RedditPostsAdapter :
    PagingDataAdapter<RedditPostEntity, RedditPostsAdapter.RedditPostsViewHolder>(
        RedditPostComparator
    ) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RedditPostsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        )

    override fun onBindViewHolder(holder: RedditPostsViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class RedditPostsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = PostItemBinding.bind(view)

        fun bind(post: RedditPostEntity) {
            binding.title.text = post.title
            binding.authorName.text = post.authorFullName
            binding.comments.text = "${post.commentsCount} comments"
            binding.subreddit.text = post.subreddit
            binding.image.load(post.thumbnail)
        }
    }

    object RedditPostComparator : DiffUtil.ItemCallback<RedditPostEntity>() {
        override fun areItemsTheSame(
            oldItem: RedditPostEntity,
            newItem: RedditPostEntity
        ): Boolean {
            // Id is unique.
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: RedditPostEntity,
            newItem: RedditPostEntity
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }
}