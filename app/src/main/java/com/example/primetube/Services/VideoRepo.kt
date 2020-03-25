package com.example.primetube.Services

import android.util.Log
import androidx.lifecycle.liveData
import com.example.primetube.model.AppError

import com.example.primetube.model.Video
import com.example.primetube.model.VideoWithChannel
import com.example.primetube.ui.home.ErrorFragment
import kotlinx.coroutines.Dispatchers
import retrofit2.http.GET
import retrofit2.http.Path
import kotlin.Error
import kotlin.math.log


interface IVideoApiService {
    @GET("home")
    suspend fun getHomeVideo(): List<Video>

    @GET("video/watch/{videoId}")
    suspend fun getSingleVideo(@Path("videoId")videoId : String): VideoWithChannel
}


class VideoRepo {

    companion object {
        var httpClient = HttpClient.getInstance(IVideoApiService::class.java)
        fun getInstance(): VideoRepo {
            return VideoRepo()
        }
    }

    val HomeVideoLists = liveData {
        var httpClient = HttpClient.getInstance(IVideoApiService::class.java)
        try {
            var result = httpClient.getHomeVideo()
            Log.i("video", result[0].videoTittle)
            emit(result)

        } catch (e: Error) {
            Log.i("video", e.message)
            throw AppError(e.message, ErrorFragment.HomeFragmentError)

        }
    }

    suspend fun getHomeVideo(): List<Video> {
        try {
            var result = httpClient.getHomeVideo()
            return result
        } catch (e: Throwable) {
            Log.i("video", e.message)
            throw AppError(e.message, ErrorFragment.HomeFragmentError)

        }

    }

    suspend fun getVideo(videoId : String) : VideoWithChannel{
        try {
            var result = httpClient.getSingleVideo(videoId)
            Log.i("video", result.videoTittle)
            return result
        } catch (e: Throwable) {
            Log.i("video", e.message)
            throw AppError(e.message, null)

        }
    }

}