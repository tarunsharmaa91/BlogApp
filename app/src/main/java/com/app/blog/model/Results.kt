package com.app.blog.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Results(
    val body: String,
    val title: String,
    val id: Int,
    val userId: Int,
) : Parcelable