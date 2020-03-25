package com.example.primetube.ui.Title

import android.content.Context
import android.preference.PreferenceManager
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.primetube.model.Error
import com.example.primetube.model.User

class SignupViewModel : ViewModel() {

    private val _error = MutableLiveData<Error>()
    val error : LiveData<Error> = _error

//    fun registerUser(context : Context , userdata : User){
//        var token = PreferenceManager.getDefaultSharedPreferences(context).getString("token" , "")
////        var userdata = User("androidFirst1" , "androidLast1" , "android1" , "android1@gmai2l2.com" , "passcode" ,
////            null , null , null , null ,null,null ,null ,null , null, null)
//        UserDataService.getInstance().add<String>(userdata, token, { tokenResult ->
//            var Pmeditor =  PreferenceManager.getDefaultSharedPreferences(context).edit()
//            Pmeditor.putString("token" , "Bearer ${tokenResult}")
//            Pmeditor.apply()
//            Log.i("retrofit" , "api registration result is ... $tokenResult")
//        }){errorResult ->
//            _error.value = errorResult
//        }
//    }
}
