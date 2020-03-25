package com.example.primetube.Services

import com.example.primetube.model.Channel
import com.example.primetube.model.ChannelHomeResponse
import retrofit2.Call
import retrofit2.http.*


interface IChannelApiService {
    @GET("channel/{channelid}")
    fun get(@Path("channelid") channelId : String, @Header("Authorization") token : String) : Call<Channel>

    @GET("channel/{channelid}/home")
    fun getChannelHome(@Path("channelid") channelId : String) : Call<ChannelHomeResponse>

    @POST("channel/register")
    fun createChannel(@Body channelData : Channel, @Header("Authorization") authtoken : String) : Call<Channel>

}

class ChannelRepo {
}