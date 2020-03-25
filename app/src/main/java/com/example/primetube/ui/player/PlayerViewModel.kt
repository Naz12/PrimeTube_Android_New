package com.example.primetube.ui.player

import android.util.Log
import androidx.lifecycle.*
import com.example.primetube.Services.VideoRepo
import com.example.primetube.model.AppError
import com.example.primetube.model.Video
import com.example.primetube.model.VideoWithChannel
import kotlinx.coroutines.launch

class PlayerViewModel : ViewModel() {

     var playWhenReady = true
     var currentWindow = 0
     var playbackPosition: Long = 0

    private var _error = MutableLiveData<AppError>()
    val error : LiveData<AppError> = _error

    private var _videoData = MutableLiveData<VideoWithChannel>()
    val videoData : LiveData<VideoWithChannel> = _videoData

    fun getVideoData(videoId : String) = viewModelScope.launch {
        try {
            var result = VideoRepo.getInstance().getVideo(videoId)
            Log.i("video" , "video result found single")
            _videoData.value = result
        }catch (error : AppError){
            _error.value = error
        }
    }

}
