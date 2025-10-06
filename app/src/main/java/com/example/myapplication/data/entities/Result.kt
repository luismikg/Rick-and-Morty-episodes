package com.example.myapplication.data.entities

import com.example.myapplication.domain.repository.model.EpisodeModel

data class Result(
    val air_date: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)

fun Result.map() : EpisodeModel{
    return  EpisodeModel(
        name = this.name,
        number = this.episode
    )
}