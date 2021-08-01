package com.app.blog.network

import com.app.blog.model.Results
import retrofit2.http.GET

interface ApiService {

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

    //Using suspend function to perform work in background
    @GET("posts")
    suspend fun getPosts(): List<Results>
}