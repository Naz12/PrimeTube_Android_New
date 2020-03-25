package com.example.primetube.Services

import android.util.Log
import com.example.primetube.model.AppError
import com.example.primetube.model.Login
import com.example.primetube.model.User
import com.example.primetube.ui.home.ErrorFragment
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface IUserApiService {
    @POST("auth/signin")
    suspend fun emailAuthentication(@Body loginData: Login): String

    @POST("auth/signup")
    suspend fun createUser(@Body user: User): String

    @GET("users/list")
    fun git(): Call<Any>
}

class UserRepo {
    companion object {
        var httpClient = HttpClient.getInstance(IUserApiService::class.java)
        fun getInstance(): UserRepo {
            return UserRepo()
        }
    }

    suspend fun registerUser(user: User): String {
        try {
            var token = httpClient.createUser(user)
            return token
        } catch (e: Throwable) {
            Log.i("user", e.message)
            throw AppError(e.message, ErrorFragment.HomeFragmentError)

        }
    }

    suspend fun authenticateWithEmail(loginData: Login) : String{
        try {
            var token = httpClient.emailAuthentication(loginData)
            Log.i("token" , token)
            return token.toString()
        } catch (e: Throwable) {
            Log.i("user", e.message)
            throw AppError(e.message , null)

        }
    }
}