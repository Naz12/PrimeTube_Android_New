package com.example.primetube.Services

import android.util.Log
import com.example.primetube.model.AppError
import com.example.primetube.model.LiveResponseResult
import com.example.primetube.ui.home.ErrorFragment
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ILiveApiService {
    @GET("live/home")
    suspend fun liveVideo(@Header("Authorization") token : String) : LiveResponseResult
}


class LiveRepo {

    companion object{
        var httpClient = HttpClient.getInstance(ILiveApiService::class.java)
        fun getInstance() : LiveRepo {
            return LiveRepo()
        }
    }

    suspend fun getLiveVideos(token : String) : LiveResponseResult{
        try {
            var result = httpClient.liveVideo(token)
            return result
        } catch (e: Throwable) {
            Log.i("live" , e.message)
            throw AppError(e.message , ErrorFragment.LiveFragmentError)

        }
    }
}