package com.example.youtubeapikt5.ui.playListActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.youtubeapikt5.models.PlayList
import com.example.youtubeapikt5.repository.Repository
import retrofit2.Response

class PlayListViewModel(private val repository: Repository) : ViewModel() {


    fun getPlayList() : LiveData<Response<PlayList>> {
        return repository.createCall()
    }

}