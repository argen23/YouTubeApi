package com.example.youtubeapikt5.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeapikt5.BuildConfig
import com.example.youtubeapikt5.models.PlayList
import com.example.youtubeapikt5.objects.Constant
import com.example.youtubeapikt5.remoteDS.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    private val youTubeApi = RetrofitClient.create()

     fun createCall(): LiveData<PlayList> {
        val data = MutableLiveData<PlayList>()

        youTubeApi.getPLayLists(Constant.PART, Constant.CHANNEL_ID, Constant.API_KEY,Constant.MAX_RESULT)
            .enqueue(object : Callback<PlayList> {

                override fun onResponse(call: Call<PlayList>, response: Response<PlayList>) {
                    if (response.isSuccessful && response.body() != null){
                        Log.e("response retrofit", response.body().toString() )
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<PlayList>, t: Throwable) {
                    print(t.stackTrace)

                }

            })
        return data
    }

}
