package com.example.mvpdemo.view

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mvpdemo.R


@BindingAdapter("urlToImage")
fun urlToImage(view: ImageView, s: String?) {
    val options = RequestOptions.placeholderOf(R.drawable.placeholder).error(R.drawable.error)
    Glide.with(view).setDefaultRequestOptions(options).load(s ?: "").into(view)
}