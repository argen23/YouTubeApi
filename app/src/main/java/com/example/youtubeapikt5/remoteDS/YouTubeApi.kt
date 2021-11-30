package com.example.youtubeapikt5.remoteDS

import com.example.youtubeapikt5.models.PlayList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApi {

    @GET("youtube/v3/playlists")
    fun getPLayLists(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") apiKey: String,
        @Query("maxResult") maxResult: Int,
    ): Call<PlayList>
}