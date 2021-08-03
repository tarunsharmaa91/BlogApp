package com.app.blog.ui.component.post_detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.blog.databinding.ViewCommentItemBinding
import com.app.blog.model.Comments

class CommentListAdapter :
    ListAdapter<Comments, CommentListAdapter.CommentListViewHolder>(DiffCallback) {

    class CommentListViewHolder(private var binding: ViewCommentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(comments: Comments) {
            binding.listing = comments
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Comments>() {
        override fun areItemsTheSame(oldItem: Comments, newItem: Comments): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Comments, newItem: Comments): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentListViewHolder {
        return CommentListViewHolder(ViewCommentItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CommentListViewHolder, position: Int) {
        val results = getItem(position)
        holder.bind(results)
    }

}