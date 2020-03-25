package com.example.primetube.data

import android.util.Log
import com.example.primetube.Services.HttpClient

import com.example.primetube.model.Error
import com.example.primetube.model.Video
import com.example.primetube.ui.home.ErrorFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//class VideoDataService : IDataSource<Video> {
//    companion object{
//        var httpClient = HttpClient.getInstance(IVideoService::class.java)
//        fun getInstance() : VideoDataService{
//            return VideoDataService()
//        }
//    }
//     fun getHome(token: String?, id: String?, search: String?, filter: String?, pageNumber: Int?,
//                 errorCallback : (errorData : com.example.primetube.model.Error) -> Unit ,
//        successCallback: (result: List<Video>?) -> Unit) {
//        httpClient.get().enqueue(object : Callback<List<Video>> {
//            override fun onFailure(call: Call<List<Video>>, t: Throwable) {
//
//                errorCallback(com.example.primetube.model.Error(t.message , ErrorFragment.HomeFragmentError))
//            }
//
//            override fun onResponse(call: Call<List<Video>>, response: Response<List<Video>>) {
//                if(response.code() ===500) errorCallback(com.example.primetube.model.Error(response.message() , ErrorFragment.HomeFragmentError))
//
//                if(response.isSuccessful){
//                    Log.i("video" , "success response")
//                    var result = response.body()
//                    Log.i("image" , result?.get(0)?.thumbnailPath)
//                    successCallback(result)
//                }
//            }
//
//
//
//        })
//    }
//
//    override fun <K> add(
//        data: Video,
//        token: String,
//        successCallback: (result: K?) -> Unit,
//        errorCallback: (error: Error?) -> Unit
//    ) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun get(
//        token: String?,
//        id: String,
//        search: String?,
//        filter: String?,
//        pageNumber: Int?,
//        successCallback: (result: Video?) -> Unit
//    ) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//}