package com.lucascabral.nasa_spacedaily

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucascabral.nasa_spacedaily.network.NasaApiInterface
import com.lucascabral.nasa_spacedaily.network.PhotoResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

interface MainView {
    fun setDailyPhoto(dailyPhoto: PhotoResponse)
}

class MainViewModel : ViewModel(), KoinComponent {
    val nasaApiInterface: NasaApiInterface by inject()
    var view: MainView? = null

    fun getDailyPhoto() {
        viewModelScope.launch(Dispatchers.IO) {
            val dailyPhoto = nasaApiInterface.getDailyPhoto()
            withContext(Dispatchers.Main) {
                view?.setDailyPhoto(dailyPhoto)
            }
        }
    }
}