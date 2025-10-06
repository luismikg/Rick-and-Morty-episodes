package com.example.myapplication.presentacion.states

import com.example.myapplication.domain.repository.model.EpisodeModel

sealed class EpisodeState {
    data object Loading : EpisodeState()
    data class EpisodeData(val episodeList: List<EpisodeModel>) : EpisodeState()
}