package com.example.primetube.data

import android.util.Log
import com.example.primetube.Services.HttpClient
import com.example.primetube.model.Login
import com.example.primetube.model.User
import com.example.primetube.ui.home.ErrorFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//class UserDataService private constructor() : IDataSource<User> {
//
//
//    override fun <K> add(data: User, token: String, successCallback: (result: K?) -> Unit,
//                         errorCallback: (error: com.example.primetube.model.Error?) -> Unit) {
//        httpClient.add(data).enqueue(object : Callback<String> {
//            override fun onFailure(p0: Call<String>, p1: Throwable) {
//                Log.i("retrofit" , p1.message)
//                errorCallback(com.example.primetube.model.Error(p1.message , ErrorFragment.SignupFragment))
//            }
//
//            override fun onResponse(p0: Call<String>, response: Response<String>) {
//                if(response.code() ===500) errorCallback(com.example.primetube.model.Error(response.message() , ErrorFragment.SignupFragment))
//                if(response.isSuccessful){
//                    var result = response.body()
//                    successCallback(result!! as K)
//                }
//
//            }
//        })
//    }
//
//
//
//
//    fun authenticateWithEmail(data: Login, successCallback : (token : String)-> Unit){
//        httpClient.emailAuthentication(data).enqueue(object : Callback<String> {
//            override fun onFailure(p0: Call<String>, p1: Throwable) {
//                Log.i("retrofit" , p1.message)
//                throw Error(p1.message)
//            }
//
//            override fun onResponse(p0: Call<String>, response: Response<String>) {
//                if(response.isSuccessful){
//                    var result = response.body()
//                    successCallback(result!!)
//                }
//            }
//        })
//    }
//
//    override fun get(token: String?, id: String, search: String?, filter: String?, pageNumber: Int?, successCallback: (result: User?) -> Unit) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//}
//
//
//
