package com.example.youtubeapikt5

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

var View.visible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }

var View.invisible: Boolean
    get() = visibility == View.INVISIBLE
    set(value) {
        visibility = if (value) View.INVISIBLE else View.VISIBLE
    }

fun ImageView.loadImage(url: String){
    Glide.with(context)
        .load(url)
        .into(this)
}
