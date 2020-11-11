package com.huitao.architecture.utils

import android.content.Context
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.huitao.architecture.R


/**
 * @author Frank
 * @date 2020/5/26.
 * email：zhuhuitao_struggle@163.com
 * description：
 */
object GlideUtil {
    fun loadPortraitByUrl(imageView: AppCompatImageView, url: String, context: Context) {
        Glide.with(context)
            .load(url)
            .apply(RequestOptions().circleCrop().error(R.drawable.image_error))
            .into(imageView)
    }

    fun loadLocalImage(imageView: ImageView, url: String, context: Context) {
        Glide.with(context)
            .load(url)
            .apply(RequestOptions().centerCrop().error(R.drawable.image_error))
            .into(imageView)
    }

    fun loadResImage(imageView: ImageView, res: Int, context: Context) {
        Glide.with(context)
            .load(res)
            .apply(RequestOptions().centerCrop().error(R.drawable.image_error))
            .into(imageView)
    }

}