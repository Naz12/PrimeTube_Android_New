package com.example.primetube.ui.live

import android.app.Application
import android.preference.PreferenceManager
import androidx.lifecycle.*
import com.example.primetube.Services.LiveRepo
import com.example.primetube.model.AppError
import com.example.primetube.ui.home.ErrorFragment

class LiveViewModel(application : Application) : AndroidViewModel(application){
    private var _error = MutableLiveData<AppError>()
    val error : LiveData<AppError> = _error


    var livestreamresult = liveData {
        try {
            var token = PreferenceManager.getDefaultSharedPreferences(getApplication()).getString("token" , "")
            if(token.isNullOrEmpty()) throw AppError("invalid token" , ErrorFragment.LiveFragmentError)

            var result = LiveRepo.getInstance().getLiveVideos(token)
            emit(result)
        }catch (error : AppError){
            _error.value = error
        }
    }
}
