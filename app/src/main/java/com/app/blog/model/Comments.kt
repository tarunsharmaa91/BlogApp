package com.app.blog.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Comments(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
): Parcelable
