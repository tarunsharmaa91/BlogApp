package com.app.blog.network

import com.app.blog.model.ClassifyAd
import retrofit2.http.GET

interface ApiService {

    companion object {
        const val BASE_URL = "https://ey3f2y0nre.execute-api.us-east-1.amazonaws.com/default/"
    }

    //Using suspend function to perform work in background
    @GET("dynamodb-writer")
    suspend fun getAds(): ClassifyAd
}