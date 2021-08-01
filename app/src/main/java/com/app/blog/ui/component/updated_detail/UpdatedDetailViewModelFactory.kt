package com.app.blog.ui.component.updated_detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.blog.model.Results

class UpdatedDetailViewModelFactory(
    private val ad: Results,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UpdatedAdDetailViewModel::class.java)) {
            return UpdatedAdDetailViewModel(ad, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}