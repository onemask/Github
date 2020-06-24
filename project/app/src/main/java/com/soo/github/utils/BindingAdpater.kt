package com.soo.github.utils

import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.soo.github.R
import com.soo.github.base.BaseAdapter

@BindingAdapter("bind:srcCompat")
fun srcCompat(view: SimpleDraweeView, url: String) {
    view.setImageURI(url.toUri(), view.context)
}

@BindingAdapter("bind:replaceItems")
fun replaceItems(recyclerView: RecyclerView, items: List<Any>?) {
    if (items == null) return

    @Suppress("UNCHECKED_CAST")
    (recyclerView.adapter as? BaseAdapter<Any>)?.run {
        setItem(items)
    }
}

@BindingAdapter("bind:textColor")
fun textColor(view: TextView, language: String?) {
    if (language == null) return
    @ColorRes
    val color = when (language) {
        "JavaScript" -> R.color.color_yellow
        "HTML" -> R.color.color_red
        "Kotlin" -> R.color.color_orange
        "Java" -> R.color.color_brown
        "TypeScript" -> R.color.color_blue
        "C++" -> R.color.color_pink
        "C#" -> R.color.color_green
        "Ruby" -> R.color.color_black
        else -> R.color.colorPrimary
    }
    view.setTextColor(ContextCompat.getColor(view.context, color))
}