package com.example.youtubeapikt5.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.youtubeapikt5.models.PlayList
import com.example.youtubeapikt5.objects.Constant
import com.example.youtubeapikt5.remoteDS.YouTubeApi
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

class Repository(private val youTubeApi: YouTubeApi) {


     fun createCall(): LiveData<Response<PlayList>> = liveData(Dispatchers.IO) {
        val response = youTubeApi.getPLayLists(
            Constant.PART, Constant.CHANNEL_ID, Constant.API_KEY,Constant.MAX_RESULT)
         emit(response)
    }

    fun createDetailCall(id : String): LiveData<Response<PlayList>> = liveData(Dispatchers.IO) {

        val response = youTubeApi.getDetailPLayList(
            Constant.PART, id ,Constant.API_KEY,Constant.MAX_RESULT)
        emit(response)
    }

}
