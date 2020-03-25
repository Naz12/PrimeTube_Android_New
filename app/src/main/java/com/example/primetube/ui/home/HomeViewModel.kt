package com.example.primetube.ui.home

import android.app.Application
import android.content.Context
import android.preference.PreferenceManager
import android.util.Log
import androidx.lifecycle.*
import com.example.primetube.Services.HttpClient

import com.example.primetube.Services.VideoRepo
import com.example.primetube.model.AppError
import com.example.primetube.model.Channel
import com.example.primetube.model.User
import com.example.primetube.model.Video
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel(application : Application) : AndroidViewModel(application) {



    private var _error = MutableLiveData<AppError>()
    val error : LiveData<AppError> = _error




    val homeVideoList= liveData {
        try {
            var data = VideoRepo().getHomeVideo()
            Log.i("video" , "video result found")
            emit(data)
        }catch (error : AppError){
            _error.value = error
        }

    }



//    fun getChannel(context : Context){
//        var token = PreferenceManager.getDefaultSharedPreferences(context).getString("token" , "")
//        Log.i("channel" , token)
//        if(token != null || token != ""){
//            ChannelDataService.getInstance().get(token, "5ce6ccb86aa9050f509ecbb5", null, null, null){ result ->
//                Log.i("channel" , "channel result")
//            }
//        }
//
//    }

//    fun getChannelHome(context : Context , channelId : String){
//        ChannelDataService.getInstance().getCannelHome(channelId){result ->
//            if(result != null)
//            Log.i("channel" , "channel home result ${result.uploads[0].videoTittle} , ${result.uploads[1].videoPath}")
//        }
//    }

//    fun createChannel(context : Context , channelData : Channel){
//        var token = PreferenceManager.getDefaultSharedPreferences(context).getString("token" , "")
//        Log.i("channel" , token)
//        ChannelDataService.getInstance().add<Channel>(channelData, token!!, { successResult ->
//            if(successResult != null) Log.i("channel" , "channel creation result ${successResult.channelName}")
//
//        },{errorResult ->
//
//        })
//    }

//    fun getHomeVideo(context : Context , pageNumber : Int) {
//         VideoDataService.getInstance().getHome(null , null , null , null , pageNumber , {errorData ->
////             _error.value = errorData
//         }){result ->
//            if(result != null) {
//                Log.i("video" , "video result ${result[0].videoTittle}")
//                _isDataAvailable.value = true
////                _videoList.value = result.toList()
//            }
//            else throw Error("failed to load home page")
//
//        }
//    }





}