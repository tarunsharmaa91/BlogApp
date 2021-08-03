package com.app.blog.network

import com.app.blog.model.Comments
import com.app.blog.model.Results
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }
    //Using suspend function to perform work in background
    @GET("posts")
    suspend fun getPosts(): List<Results>

    @GET("posts/{id}/comments")
    suspend fun getComments(@Path("id") postId: Int): List<Comments>

}