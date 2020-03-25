package com.example.primetube.ui.Title

import android.app.Application
import android.content.Context
import android.preference.PreferenceManager
import android.util.Log
import androidx.lifecycle.*
import com.example.primetube.Services.UserRepo

import com.example.primetube.model.AppError
import com.example.primetube.model.Login
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : AndroidViewModel(application) {
//    var _token : MutableLiveData<String> = MutableLiveData()
//    var token : LiveData<String> = _token

    private var _error = MutableLiveData<AppError>()
    val error: LiveData<AppError> = _error


    fun signinwithEmail(loginData: Login) = liveData {
        try {
            var token = UserRepo.getInstance().authenticateWithEmail(loginData)
            if (token.isBlank()) throw AppError("Invalid token", null)

            var Pmeditor = PreferenceManager.getDefaultSharedPreferences(getApplication()).edit()
            Log.i("toekn", "token viewmodel result is ... $token")
            Pmeditor.putString("token", "Bearer $token")
            emit(true)
            Pmeditor.apply()

        } catch (error: AppError) {
            emit(false)
            _error.value = error
        }


    }
}
