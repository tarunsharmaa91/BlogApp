package com.app.blog.ui.component.post_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.app.blog.databinding.UpdatedAdDetailFragmentBinding
import com.app.blog.utils.AppUtils

class PostDetail : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = UpdatedAdDetailFragmentBinding.inflate(inflater)
        val application = requireNotNull(activity).application
        //To allow data binding to observe live data with life cycle of fragment
        binding.lifecycleOwner = this
        binding.fragment = this

        val adData = PostDetailArgs.fromBundle(requireArguments()).selectedAd
        val viewModelFactory = PostDetailViewModelFactory(adData, application)
        binding.viewModel = ViewModelProvider(
            this, viewModelFactory
        ).get(PostDetailViewModel::class.java)
        binding.utils = AppUtils()
        return binding.root
    }

    fun onSearch() {
        //this.findNavController().navigate(AdDetailDirections.actionAdDetailToAdList())
        this.findNavController().popBackStack()
    }

}