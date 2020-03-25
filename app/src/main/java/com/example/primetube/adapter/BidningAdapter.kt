package com.example.primetube.adapter

import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.primetube.R
import com.example.primetube.Services.PicassoCircleTransformation
import com.example.primetube.model.Video
import com.squareup.picasso.Picasso
import java.util.*


@BindingAdapter("homeVideoList")
fun addVideoList(view : RecyclerView , data : List<Video>?){
    var adapter = VideoAdapter(view.context , R.layout.home_page , data)
    view.layoutManager = LinearLayoutManager(view.context);
    view.adapter = adapter
}

@BindingAdapter("videoList")
fun addListStyleVideoList(view : RecyclerView , data : List<Video>?){
    var adapter = VideoAdapter(view.context , R.layout.list_style_layout , data)
    view.layoutManager = LinearLayoutManager(view.context);
    view.adapter = adapter
}

@BindingAdapter("scrollableVideoList")
fun addScrollableVideoList(view : RecyclerView , data : List<Video>?){
    var adapter = VideoAdapter(view.context , R.layout.scroll_style_layout , data)
    view.layoutManager = LinearLayoutManager(view.context , LinearLayoutManager.HORIZONTAL , false);
    view.adapter = adapter
}

@BindingAdapter("videotype")
fun formatVideotype(view : TextView , videoInfo : Video){
    when {
        videoInfo.isLive -> view.text = "Live Now"
        !videoInfo.livePath.isNullOrEmpty() -> view.text = "Live"
        else -> when (videoInfo.videoType) {
            "FREE" -> view.text = ""
            else -> view.text = videoInfo.videoType
        }
    }

}

@BindingAdapter("imageData")
fun addImageData(view : ImageView , imagesrc : String){
    var refinedImageSrc = imagesrc.replace("localhost" , "10.240.72.81")
    Picasso.get().load(refinedImageSrc).placeholder(R.drawable.backgroundd)
        .fit().centerCrop().into(view)
}


@BindingAdapter("cirlceimage")
fun TransformTocircleImage(view : ImageView , imagesrc : String?){
    if((!imagesrc.isNullOrEmpty()) && imagesrc.contains("localhost")){
        var refinedImageSrc = imagesrc.replace("localhost" , "10.240.72.81")
        Picasso.get().load(refinedImageSrc).placeholder(R.drawable.backgroundd)
            .transform(PicassoCircleTransformation())
            .fit().centerCrop().into(view)
    }else{
        Picasso.get().load(R.drawable.backgroundd).placeholder(R.drawable.backgroundd)
            .transform(PicassoCircleTransformation())
            .fit().centerCrop().into(view)
    }

}

@BindingAdapter("isDataAvailable")
fun checkVisibility(view : View, check : Boolean){
    if(check) view.visibility = View.VISIBLE
    else view.visibility = View.INVISIBLE
}


@BindingAdapter("date")
fun formatDate(view : TextView , date : Date?){
    var monthes =  Array(12){"Jan"; "Feb"; "Mar"; "Apr"; "May"; "Jun"; "July"; "Aug"; "Sep"; "Oct"; "Nov"; "Dec"}
    var month = date?.month
    var year  = date?.year
    var day = date?.date
    view.text = "${monthes.get(month?:0)} $day, $year"
}

