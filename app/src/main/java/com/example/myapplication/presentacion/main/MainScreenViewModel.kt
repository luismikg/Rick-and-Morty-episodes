package com.example.myapplication.presentacion.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.repository.EpisodeRepository
import com.example.myapplication.presentacion.states.EpisodeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val episodeRepository: EpisodeRepository
) : ViewModel() {

    private var _episodeState: MutableStateFlow<EpisodeState> =
        MutableStateFlow(EpisodeState.Loading)
    val episodeState: StateFlow<EpisodeState> = _episodeState

    init {
        getEpisodes()
    }

    private fun getEpisodes() {
        _episodeState.value = EpisodeState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            episodeRepository.getEpisode().collectLatest { data ->
                data.onSuccess { episodesModelList ->
                    _episodeState.value = EpisodeState.EpisodeData(episodeList = episodesModelList)
                }
            }
        }
    }
}