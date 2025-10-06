package com.example.myapplication.data.repository

import com.example.myapplication.data.ApiService
import com.example.myapplication.domain.repository.EpisodeRepository
import com.example.myapplication.domain.repository.model.EpisodeModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EpisodeRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : EpisodeRepository {

    override fun getEpisode(): Flow<Result<List<EpisodeModel>>> {
        return flow {
            val response = apiService.getEpisode()

            if (response.isSuccessful) {
                response.body()?.let { episodeResponse ->
                    emit(
                        Result.success(
                            episodeResponse.results.map { resultsEpisode ->
                                EpisodeModel(
                                    name = resultsEpisode.name,
                                    number = resultsEpisode.episode
                                )
                            }
                        )
                    )
                } ?: run {
                    emit(Result.failure(Exception("Error Body null")))
                }
            } else {
                emit(Result.failure(Exception("Not Success service called!")))
            }
        }
    }
}