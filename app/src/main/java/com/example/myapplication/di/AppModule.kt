package com.example.myapplication.di

import com.example.myapplication.data.ApiService
import com.example.myapplication.data.ConstantsAPI
import com.example.myapplication.data.repository.EpisodeRepositoryImpl
import com.example.myapplication.domain.repository.EpisodeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(ConstantsAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun providesEpisodeRepository(apiService: ApiService): EpisodeRepository {
        return EpisodeRepositoryImpl(apiService)
    }
}