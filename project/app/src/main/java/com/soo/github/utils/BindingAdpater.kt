package com.soo.github.utils

import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.soo.github.base.BaseAdapter

@BindingAdapter("bind:srcCompat")
fun srcCompat(view: SimpleDraweeView, url: String) {
    view.setImageURI(url.toUri(), view.context)
}

@BindingAdapter("bind:replaceItems")
fun replaceItems(recyclerView: RecyclerView, item: List<Any>?) {
    if (item == null) return

    @Suppress("UNCHECKED_CAST")
    (recyclerView.adapter as BaseAdapter<Any>).run {
        replaceItems(item)
        notifyDataSetChanged()
    }
}