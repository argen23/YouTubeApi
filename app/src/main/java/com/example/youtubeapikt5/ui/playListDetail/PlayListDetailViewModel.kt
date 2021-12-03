package com.example.youtubeapikt5.ui.playListDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.youtubeapikt5.models.PlayList
import com.example.youtubeapikt5.repository.Repository
import retrofit2.Response

class PlayListDetailViewModel(private val repository: Repository) : ViewModel() {

    fun getDetailPlayList(id : String) : LiveData<Response<PlayList>>  {
        return repository.createDetailCall(id)
    }

}