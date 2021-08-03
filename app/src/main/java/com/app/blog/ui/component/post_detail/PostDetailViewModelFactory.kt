package com.app.blog.ui.component.post_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.blog.model.Results
import com.app.blog.network.ApiService

class PostDetailViewModelFactory(
    private val ad: Results,
    private val apiService: ApiService

) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostDetailViewModel::class.java)) {
            return PostDetailViewModel(ad, apiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}