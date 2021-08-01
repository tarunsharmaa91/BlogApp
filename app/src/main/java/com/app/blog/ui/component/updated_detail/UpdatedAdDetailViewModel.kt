package com.app.blog.ui.component.updated_detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.blog.model.Results

class UpdatedAdDetailViewModel(ad: Results, application: Application) : AndroidViewModel(application) {

    private val _selectedAdDetail = MutableLiveData<Results>()

    // The external LiveData for the SelectedProperty
    val selectedProperty: LiveData<Results>
        get() = _selectedAdDetail

    // Initialize the _selectedProperty MutableLiveData
    init {
        _selectedAdDetail.value = ad
    }
}