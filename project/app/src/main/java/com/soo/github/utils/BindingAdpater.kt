package com.soo.github.utils

import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.facebook.drawee.view.SimpleDraweeView

@BindingAdapter("bind:srcCompat")
fun srcCompat(view: SimpleDraweeView, url: String) {
    view.setImageURI(url.toUri(), view.context)
}