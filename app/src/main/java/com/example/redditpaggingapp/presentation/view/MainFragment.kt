package com.example.redditpaggingapp.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.redditpaggingapp.R
import com.example.redditpaggingapp.databinding.FragmentMainBinding
import com.example.redditpaggingapp.presentation.adapter.RedditPostsAdapter
import com.example.redditpaggingapp.presentation.viewModel.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val binding: FragmentMainBinding by viewBinding()

    private val viewModel: MainViewModel by viewModel()

    private val adapter = RedditPostsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter = adapter
        lifecycleScope.launch {
            viewModel.posts.collectLatest {
                adapter.submitData(it)
            }
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }

}