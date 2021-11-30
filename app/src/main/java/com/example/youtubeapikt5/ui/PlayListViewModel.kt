package com.example.youtubeapikt5.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.youtubeapikt5.models.PlayList
import com.example.youtubeapikt5.repository.Repository

class PlayListViewModel : ViewModel() {

    fun getPlayList() : LiveData<PlayList> {
        return Repository().createCall()
    }

}