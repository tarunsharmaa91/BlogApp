package com.app.blog.ui.component.updated_list.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.blog.model.ClassifyAd
import com.app.blog.model.Results
import com.app.blog.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class ApiStatus {
    LOADING,
    ERROR,
    COMPLETED
}

@HiltViewModel
class UpdatedAdListViewModel @Inject constructor(apiService: ApiService) : ViewModel() {
    //This is to store the current request status (Internal)
    private val _status = MutableLiveData<ApiStatus>()

    //External Mutable Live Data to store status
    val status: LiveData<ApiStatus>
        get() = _status

    //For result

    private val _results = MutableLiveData<ClassifyAd>()

    val result: LiveData<ClassifyAd>
        get() = _results

    //For navigation

    private val _navigateToAdDetail = MutableLiveData<Results>()

    val navigateToAdDetail: LiveData<Results>
        get() = _navigateToAdDetail

    init {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
                //_results.value = AdsApi.retrofitService.getAds()
                _results.value = apiService.getAds()
                _status.value = ApiStatus.COMPLETED
            } catch (ex: Exception) {
                _status.value = ApiStatus.ERROR
            }
        }
    }

    fun displayAdDetail(result: Results) {
        _navigateToAdDetail.value = result
    }

    @SuppressLint("NullSafeMutableLiveData")
    fun displayAdDetailComplete() {
        _navigateToAdDetail.value = null
    }


}


