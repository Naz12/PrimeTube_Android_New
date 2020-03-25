package com.example.primetube.Services

import android.preference.PreferenceManager
import com.example.primetube.model.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*



class HttpClient {
 companion object{

     val baseUrl = "http://10.240.72.81:3000/"
     var retrofit = Retrofit.Builder()
         .baseUrl(baseUrl)
         .addConverterFactory(GsonConverterFactory.create())
         .build()

     fun<T> getInstance(service : Class<T>) : T{
         return retrofit.create(service)
     }
 }



}