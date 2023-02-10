package com.example.redditpaggingapp.data.di

import com.example.redditpaggingapp.data.api.RedditApi
import com.example.redditpaggingapp.data.mapper.RedditPostMapper
import com.example.redditpaggingapp.data.repository.RedditRepository
import com.example.redditpaggingapp.data.repository.RedditRepositoryImpl
import com.example.redditpaggingapp.presentation.viewModel.MainViewModel
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        Retrofit.Builder()
            .baseUrl("http://www.reddit.com")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(httpClient.build())
            .build()
            .create(RedditApi::class.java)
    }

    factory { RedditPostMapper() }
    single<RedditRepository> { RedditRepositoryImpl(get(), get()) }
    viewModel { MainViewModel(get()) }
}