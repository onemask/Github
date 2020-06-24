package com.soo.github.utils

import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.soo.github.base.BaseAdapter

@BindingAdapter("bind:srcCompat")
fun srcCompat(view: SimpleDraweeView, url: String) {
    view.setImageURI(url.toUri(), view.context)
}

/*@BindingAdapter("bind:replaceItems")
fun replaceItems(recyclerView: RecyclerView, item: List<Any>?) {
    if (item == null) return

    @Suppress("UNCHECKED_CAST")
    (recyclerView.adapter as BaseAdapter<Any>).run {
        setItem(item)
        notifyDataSetChanged()
    }
}*/

@BindingAdapter("bind:replaceItems")
fun RecyclerView.replaceItems(items: List<Any>?) {
    if (items == null) return

    @Suppress("UNCHECKED_CAST")
    (this.adapter as? BaseAdapter<Any>)?.run {
        this.setItem(items)
    }
}

@BindingAdapter("bind:followingText")
fun followingText(view: TextView, count: String?) {
    val string = if (count.isNullOrEmpty())
        "Following(0)"
    else
        "Following($count)"
    view.text = string
}

@BindingAdapter("bind:followerText")
fun followerText(view: TextView, count: String?) {
    val string = if (count.isNullOrEmpty())
        "Follower(0)"
    else
        "Follower($count)"
    view.text = string
}