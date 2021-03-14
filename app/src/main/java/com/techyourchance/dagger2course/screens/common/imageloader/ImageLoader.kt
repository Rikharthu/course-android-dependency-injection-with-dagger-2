package com.techyourchance.dagger2course.screens.common.imageloader

import android.app.Activity
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import javax.inject.Inject

class ImageLoader @Inject constructor(private val activity: Activity) {

    private val requestOptions = RequestOptions.centerCropTransform()

    fun loadImage(imageUrl: String, target: ImageView) {
        Glide.with(activity).load(imageUrl).apply(requestOptions).into(target)
    }
}