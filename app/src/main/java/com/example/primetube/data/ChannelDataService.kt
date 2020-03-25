package com.example.primetube.data

import android.util.Log
import com.example.primetube.Services.HttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.primetube.model.Channel
import com.example.primetube.model.ChannelHomeResponse


//class ChannelDataService : IDataSource<Channel>{
//    companion object{
//       private var httpClient = HttpClient.getInstance(IChannelService::class.java)
//        fun getInstance() : ChannelDataService{
//            return ChannelDataService()
//        }
//    }
//
//    override fun <K> add(data: Channel, token: String, successCallback: (result: K?) -> Unit,
//                         errorCallback: (error: com.example.primetube.model.Error?) -> Unit) {
//        httpClient.createChannel(data , token).enqueue(object : Callback<Channel> {
//            override fun onFailure(p0: Call<Channel>, p1: Throwable) {
//                throw Error(p1.message)
//            }
//
//            override fun onResponse(p0: Call<Channel>, p1: Response<Channel>) {
//
//                if(p1.code() ===500) throw Error("Internal server error ${p1.message()}")
//
//                if(p1.isSuccessful){
//                    Log.i("channel" , "success response")
//                    var result = p1.body()
//                    successCallback(result as K)
//                }
//
//            }
//
//        })
//    }
//
//    override fun get(token: String?, id: String,search: String?, filter: String?, pageNumber: Int?, successCallback: (result: Channel?) -> Unit) {
//        httpClient.get(id , token!!).enqueue(object : Callback<Channel>{
//            override fun onFailure(p0: Call<Channel>, p1: Throwable) {
//                throw Error(p1.message)
//            }
//
//            override fun onResponse(p0: Call<Channel>, p1: Response<Channel>) {
//                var result = p1.body()
//                successCallback(result)
//            }
//
//
//        })
//    }
//
//
//    fun getCannelHome(channelId : String , successCallback: (result: ChannelHomeResponse?) -> Unit){
//        httpClient.getChannelHome(channelId).enqueue(object : Callback<ChannelHomeResponse> {
//            override fun onFailure(p0: Call<ChannelHomeResponse>, p1: Throwable) {
//                throw Error(p1.message)
//            }
//
//            override fun onResponse(p0: Call<ChannelHomeResponse>, p1: Response<ChannelHomeResponse>) {
//                var result = p1.body()
//                successCallback(result)
//            }
//        })
//    }
//}