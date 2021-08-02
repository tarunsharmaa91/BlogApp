package com.app.blog.ui.component.post_detail

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.blog.model.Results
import com.app.blog.ui.component.post_list.viewmodel.ApiStatus

class PostDetailViewModel(
    ad: Results,
    application: Application
) :
    ViewModel() {

    //This is to store the current request status (Internal)
    private val _status = MutableLiveData<ApiStatus>()

    //External Mutable Live Data to store status
    val status: LiveData<ApiStatus>
        get() = _status

    private val _selectedAdDetail = MutableLiveData<Results>()

    // The external LiveData for the SelectedProperty
    val selectedProperty: LiveData<Results>
        get() = _selectedAdDetail

    // Initialize the _selectedProperty MutableLiveData
    init {
        _selectedAdDetail.value = ad
        _selectedAdDetail.value = ad
    }

    /* fun getCommentsForPost(id: Int) {
         viewModelScope.launch {
             _status.value = ApiStatus.LOADING
             try {
                 _selectedAdDetail.value = apiService.getCommentsForPost
                 _status.value = ApiStatus.COMPLETED
             } catch (ex: Exception) {
                 _status.value = ApiStatus.ERROR
             }
         }
     }*/
}