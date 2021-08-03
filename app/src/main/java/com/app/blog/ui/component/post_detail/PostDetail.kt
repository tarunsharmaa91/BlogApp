package com.app.blog.ui.component.post_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.app.blog.databinding.PostDetailFragmentBinding
import com.app.blog.network.ApiService
import com.app.blog.ui.component.post_detail.adapter.CommentListAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PostDetail : Fragment() {

    @Inject
    lateinit var apiService: ApiService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = PostDetailFragmentBinding.inflate(inflater)

        //To allow data binding to observe live data with life cycle of fragment
        binding.lifecycleOwner = this

        binding.fragment = this

        val adData = PostDetailArgs.fromBundle(requireArguments()).selectedAd

        val viewModelFactory = PostDetailViewModelFactory(adData, apiService)

        binding.viewModel = ViewModelProvider(
            this, viewModelFactory
        ).get(PostDetailViewModel::class.java)
        binding.commentList.adapter = CommentListAdapter()
        return binding.root
    }

    fun onBack() {
        this.findNavController().popBackStack()
    }

}