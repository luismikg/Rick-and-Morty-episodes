package com.example.myapplication.data

import com.example.myapplication.data.entities.EpisodeResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    //URL: https://rickandmortyapi.com/api/episode

    @GET(ConstantsAPI.EPISODE_SERVICE)
    suspend fun getEpisode() : Response<EpisodeResponse>
}