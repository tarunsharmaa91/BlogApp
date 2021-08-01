package com.app.blog.ui.list.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.app.blog.databinding.UpdatedAdListFragmentBinding
import com.app.blog.ui.component.updated_list.adapter.AdListAdapter
import com.app.blog.ui.component.updated_list.viewmodel.UpdatedAdListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdatedAdList : Fragment() {

    private val viewModel: UpdatedAdListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = UpdatedAdListFragmentBinding.inflate(inflater)

        //To allow data binding to observe live data with life cycle of fragment
        binding.lifecycleOwner = this

        //Now I have to give binding access to AdListViewModel
        binding.viewModel = viewModel

        binding.adList.adapter = AdListAdapter(AdListAdapter.OnClickListener {
            viewModel.displayAdDetail(it)
        })

        viewModel.navigateToAdDetail.observe(viewLifecycleOwner, {
            if (null != it) {
                // Must find the NavController from the Fragment

                //Wen you have function literal with one parameter
                this.findNavController().navigate(UpdatedAdListDirections.actionShowDetail(it))
                // Tell the ViewModel we've made the navigate call to prevent multiple navigation
                viewModel.displayAdDetailComplete()
            }
        })

        return binding.root
    }


}
