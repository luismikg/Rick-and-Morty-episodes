package com.example.myapplication.domain.repository

import com.example.myapplication.domain.repository.model.EpisodeModel
import kotlinx.coroutines.flow.Flow

interface EpisodeRepository {

    fun getEpisode() : Flow<Result<List<EpisodeModel>>>
}