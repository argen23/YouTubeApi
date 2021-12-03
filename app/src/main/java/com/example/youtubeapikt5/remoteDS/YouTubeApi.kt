package com.example.youtubeapikt5.remoteDS

import com.example.youtubeapikt5.models.PlayList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApi {

    @GET("youtube/v3/playlists")
    suspend fun getPLayLists(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") apiKey: String,
        @Query("maxResults") maxResult: Int,
    ): Response<PlayList>



    @GET("youtube/v3/playlistItems")
    suspend fun getDetailPLayList(
        @Query("part")part : String,
        @Query("playlistId") playlistId: String,
        @Query("key") key : String,
        @Query("maxResults") maxResults : Int
    ) : Response<PlayList>

}