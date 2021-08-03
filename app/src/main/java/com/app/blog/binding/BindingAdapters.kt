package com.app.blog

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.blog.model.Comments
import com.app.blog.model.Results
import com.app.blog.ui.component.post_detail.adapter.CommentListAdapter
import com.app.blog.ui.component.post_list.adapter.PostListAdapter
import com.app.blog.ui.component.post_list.viewmodel.ApiStatus
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Results>?) {
    val adapter = recyclerView.adapter as PostListAdapter
    adapter.submitList(data)
}

@BindingAdapter("commentData")
fun bindCommentRecyclerView(recyclerView: RecyclerView, data: List<Comments>?) {
    val adapter = recyclerView.adapter as CommentListAdapter
    adapter.submitList(data)
}

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: ApiStatus?) {
    when (status) {
        ApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        ApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        ApiStatus.COMPLETED -> {
            statusImageView.visibility = View.GONE
        }
    }
}
