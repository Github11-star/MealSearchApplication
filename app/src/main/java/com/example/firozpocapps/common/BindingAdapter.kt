package com.example.firozpocapps.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.firozpocapps.R

@BindingAdapter("urlToImage")
fun urlToImage(view: ImageView, str: String?){

    str?.let {
        val option = RequestOptions.placeholderOf(R.drawable.loading).error(R.drawable.error)
        Glide.with(view).setDefaultRequestOptions(option).load(str).into(view)
    }
}