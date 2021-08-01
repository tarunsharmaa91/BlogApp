package com.app.blog.ui.component.post_list.repository

import com.app.blog.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostListRepo @Inject constructor(private val apiService: ApiService) {

    fun getAdList() = flow{
        emit(apiService.getPosts())
    }.flowOn(Dispatchers.IO)

}