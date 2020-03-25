package com.example.primetube.adapter

import android.content.Context
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.primetube.MainActivity
import com.example.primetube.R
import com.example.primetube.databinding.HomePageBinding
import com.example.primetube.databinding.ListStyleLayoutBinding
import com.example.primetube.databinding.ScrollStyleLayoutBinding
import com.example.primetube.model.Video
import com.squareup.picasso.Picasso


class VideoAdapter(var context: Context, var layoutfile: Int, var list: List<Video>?) : RecyclerView.Adapter<VideoAdapter.ViewHolder>() {

    private lateinit var imainActivity : MainActivity

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        var context = recyclerView.context
        imainActivity = context as MainActivity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (layoutfile == R.layout.home_page) {
            var homePageBinding =
                HomePageBinding.inflate(LayoutInflater.from(context), parent, false)
            return ViewHolder(homePageBinding.root , layoutfile)
        }
        else if(layoutfile == R.layout.list_style_layout){
            var listStyleLayoutBinding : ListStyleLayoutBinding = ListStyleLayoutBinding.inflate(
                LayoutInflater.from(context) , parent , false)
            return ViewHolder(listStyleLayoutBinding.root , layoutfile)
        }
        else {
            var scrollStyleLayoutBinding =
                ScrollStyleLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
            return ViewHolder(scrollStyleLayoutBinding.root , layoutfile)
        }
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var videoData: Video = list!![position]
        if (layoutfile == R.layout.home_page) {
            holder.homeBiding?.video = videoData
            holder.videoId = videoData._id
        }else if(layoutfile == R.layout.list_style_layout){
            holder.listStyleBinding?.video = videoData
        }
        else {
            holder.scrollstyleBinding?.video = videoData
        }


    }


    inner class ViewHolder(view: View, var layoutfile: Int) : RecyclerView.ViewHolder(view) {
        var homeBiding: HomePageBinding? = null;
        var scrollstyleBinding: ScrollStyleLayoutBinding? = null
        var listStyleBinding : ListStyleLayoutBinding? = null;
        var videoId : String? = null

        init {
            if (layoutfile == R.layout.home_page) {
                homeBiding = DataBindingUtil.bind(view)
                homeBiding!!.imainActivity = imainActivity
//                homeBiding!!.videocontainerCardview.setOnClickListener{
//                   var activity = context as MainActivity
//                    activity.navigateToPlayerView(videoId!!)
//                }
            }else if(layoutfile == R.layout.list_style_layout){
                listStyleBinding = DataBindingUtil.bind(view)
            }
            else {
                scrollstyleBinding = DataBindingUtil.bind(view)
            }
        }

    }
}