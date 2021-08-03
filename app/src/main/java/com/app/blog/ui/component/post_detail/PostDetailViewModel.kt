package com.app.blog.ui.component.post_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.blog.model.Comments
import com.app.blog.model.Results
import com.app.blog.network.ApiService
import kotlinx.coroutines.launch

class PostDetailViewModel constructor(
    ad: Results,
    apiService: ApiService
) :
    ViewModel() {

    private val _comments = MutableLiveData<List<Comments>>()

    // The external LiveData for the SelectedProperty
    val comments: LiveData<List<Comments>>
        get() = _comments

    // Initialize the _selectedProperty MutableLiveData
    init {
        viewModelScope.launch {
            try {
                _comments.value = apiService.getComments(ad.id)
            } catch (ex: Exception) {
                //Handle error
            }
        }
    }
}