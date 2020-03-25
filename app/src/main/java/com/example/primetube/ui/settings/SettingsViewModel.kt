package com.example.primetube.ui.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {
    // TODO: Implement the ViewModel\
    var text = MutableLiveData<String>().apply {
        value = "This is Setting Fragment"
    }

}
