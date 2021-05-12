package com.lucascabral.nasa_spacedaily

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucascabral.nasa_spacedaily.network.PhotoResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface MainView {
    fun setDailyPhoto(dailyPhoto: PhotoResponse)
}

class MainViewModel : ViewModel() {
    var view: MainView? = null

    fun getDailyPhoto() {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
            }
        }
    }
}